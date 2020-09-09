package com.imooc.oa.service;

import com.imooc.oa.dao.EmployeeDao;
import com.imooc.oa.entity.Employee;
import com.imooc.oa.utils.MybatisUtils;

/**
 * @Author Tianhao Tao
 * @Date 2020/9/9 15:16
 * @Version 1.0
 */

public class EmployeeService {
    /**
     * 按编号查找员工
     * @param employeeId 员工编号
     * @return 员工对象，不存在时返回null
     */
    public Employee selectByEmployeeId(Long employeeId){
        return (Employee) MybatisUtils.executeQuery(sqlSession -> {
           EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
           return employeeDao.selectByEmployeeId(employeeId);
        });
    }
}
