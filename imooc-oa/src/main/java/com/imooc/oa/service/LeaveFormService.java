package com.imooc.oa.service;

/**
 * @Author Tianhao Tao
 * @Date 2020/9/14 9:19
 * @Version 1.0
 */

import com.imooc.oa.dao.EmployeeDao;
import com.imooc.oa.dao.LeaveFormDao;
import com.imooc.oa.dao.ProcessFlowDao;
import com.imooc.oa.entity.Employee;
import com.imooc.oa.entity.LeaveForm;
import com.imooc.oa.entity.ProcessFlow;
import com.imooc.oa.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 请假单流程服务
 */
public class LeaveFormService {
    /**
     * 创建请假单
     *
     * @param form 前端输入的请假单数据
     * @return 持久化后的请假单对象
     */
    public LeaveForm createLeaveForm(LeaveForm form) {
        LeaveForm savedForm = (LeaveForm) MybatisUtils.executeUpdate(sqlSession -> {
            //1.持久化form表单数据,8级以下员工表单状态为processing,8级(总经理)状态为approved.

            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            Employee employee = employeeDao.selectByEmployeeId(form.getEmployeeId());
            if (employee.getLevel() == 8) {
                form.setState("approved");
            } else {
                form.setState("processing");
            }
            LeaveFormDao leaveFormDao = sqlSession.getMapper(LeaveFormDao.class);
            leaveFormDao.insert(form);
            //2.增加第一条流程数据,说明表单已提交,状态为complete
            ProcessFlowDao processFlowDao = sqlSession.getMapper(ProcessFlowDao.class);
            ProcessFlow processFlow = new ProcessFlow();
            processFlow.setFormId(form.getFormId());
            processFlow.setOperatorId(employee.getEmployeeId());
            processFlow.setAction("apply");
            processFlow.setCreateTime(new Date());
            processFlow.setOrderNo(1);
            processFlow.setState("complete");
            processFlow.setIsLast(0);
            processFlowDao.insert(processFlow);
            //3.分情况创建其余流程数据
            //3.1 7级以下员工,生成部门经理审批任务,请假时间大于72小时,还需生成总经理审批任务
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH时");
            if (employee.getLevel() < 7) {
                Employee dmanager = employeeDao.selectLeader(employee);
                ProcessFlow flow2 = new ProcessFlow();
                flow2.setFormId(form.getFormId());
                flow2.setOperatorId(dmanager.getEmployeeId());
                flow2.setAction("audit");
                flow2.setCreateTime(new Date());
                flow2.setOrderNo(2);
                flow2.setState("process");
                long diff = form.getEndTime().getTime() - form.getStartTime().getTime();
                float hours = diff / (1000 * 60 * 60) * 1f;
                if (hours >= BussinessConstants.MANAGER_AUDIT_HOURS) {
                    flow2.setIsLast(0);
                    processFlowDao.insert(flow2);
                    Employee manager = employeeDao.selectLeader(dmanager);
                    ProcessFlow flow3 = new ProcessFlow();
                    flow3.setFormId(form.getFormId());
                    flow3.setOperatorId(manager.getEmployeeId());
                    flow3.setAction("audit");
                    flow3.setCreateTime(new Date());
                    flow3.setState("ready");
                    flow3.setOrderNo(3);
                    flow3.setIsLast(1);
                    processFlowDao.insert(flow3);
                } else {
                    flow2.setIsLast(1);
                    processFlowDao.insert(flow2);
                }
            } else if (employee.getLevel() == 7) {//部门经理
                //3.2 7级员工,生成总经理审批任务
                Employee manager = employeeDao.selectLeader(employee);
                ProcessFlow flow = new ProcessFlow();
                flow.setFormId(form.getFormId());
                flow.setOperatorId(manager.getEmployeeId());
                flow.setAction("audit");
                flow.setCreateTime(new Date());
                flow.setState("process");
                flow.setOrderNo(2);
                flow.setIsLast(1);
                processFlowDao.insert(flow);
                //请假单已提交消息
//                String noticeContent = String.format("您的请假申请[%s-%s]已提交,请等待上级审批."
//                        , sdf.format(form.getStartTime()), sdf.format(form.getEndTime()));
//                noticeDao.insert(new Notice(employee.getEmployeeId(), noticeContent));

            }else if(employee.getLevel()==8){
                //3.3 8级员工,生成总经理审批任务,系统自动通过
                Employee manager = employeeDao.selectLeader(employee);
                ProcessFlow flow = new ProcessFlow();
                flow.setFormId(form.getFormId());
                flow.setOperatorId(manager.getEmployeeId());
                flow.setAction("audit");
                flow.setResult("approved");
                flow.setReason("自动通过");
                flow.setCreateTime(new Date());
                flow.setAuditTime(new Date());
                flow.setState("complete");
                flow.setOrderNo(2);
                flow.setIsLast(1);
                processFlowDao.insert(flow);
            }
            return form;
        });
        return savedForm;
    }
}
