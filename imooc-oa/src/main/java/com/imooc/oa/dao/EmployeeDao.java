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
}
