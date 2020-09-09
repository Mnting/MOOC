package com.imooc.oa.service;

import com.imooc.oa.dao.DepartmentDao;
import com.imooc.oa.dao.EmployeeDao;
import com.imooc.oa.entity.Department;
import com.imooc.oa.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * @Author Tianhao Tao
 * @Date 2020/9/9 16:53
 * @Version 1.0
 */
public class DepartmentService {
    /**
     * 按编号得到部门对象
     * @param DepartmentId 部门编号
     * @return 部门对象，null代表部门不存在
     */
    public Department selectByDepartmentId(Long DepartmentId){
        return (Department) MybatisUtils.executeQuery(sqlSession -> {
            DepartmentDao departmentDao = sqlSession.getMapper(DepartmentDao.class);
            return departmentDao.selectByDepartmentId(DepartmentId);
        });
    }
}
