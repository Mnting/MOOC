package com.imooc.oa.dao;

import com.imooc.oa.entity.Employee;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author Tianhao Tao
 * @Date 2020/9/9 14:43
 * @Version 1.0
 */
public interface EmployeeDao {
    public Employee selectByEmployeeId(Long employeeId);

    /**
     * 根据传入员工对象获取上级主管对象
     * @param employee 员工对象
     * @return 上级主管对象
     */
    public Employee selectLeader(@Param("emp") Employee employee);
}
