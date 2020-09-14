package com.imooc.oa.service;

/**
 * @Author Tianhao Tao
 * @Date 2020/9/14 9:19
 * @Version 1.0
 */

import com.imooc.oa.dao.EmployeeDao;
import com.imooc.oa.entity.LeaveForm;
import com.imooc.oa.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * 请假单流程服务
 */
public class LeaveFormService {
    /**
     * 创建请假单
     * @param form 前端输入的请假单数据
     * @return 持久化后的请假单对象
     */
    public LeaveForm createLeaveForm(LeaveForm form) {
        MybatisUtils.executeUpdate(sqlSession -> {
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            employeeDao.selectByEmployeeId()
        //1.持久化form表单数据,8级以下员工表单状态为processing,8级(总经理)状态为approved.
        //2.增加第一条流程数据,说明表单已提交,状态为complete
        //3.分情况创建其余流程数据
        //3.1 7级以下员工,生成部门经理审批任务,请假时间大于72小时,还需生成总经理审批任务
        //3.2 7级员工,生成总经理审批任务
        //3.3 8级员工,生成总经理审批任务,系统自动通过
        });
    }
}
