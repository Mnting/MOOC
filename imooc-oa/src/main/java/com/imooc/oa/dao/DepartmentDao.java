package com.imooc.oa.dao;

import com.imooc.oa.entity.Department;

/**
 * @Author Tianhao Tao
 * @Date 2020/9/9 16:52
 * @Version 1.0
 */
public interface DepartmentDao {
    public Department selectByDepartmentId(Long departmentID);
}
