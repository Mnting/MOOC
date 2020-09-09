package com.imooc.oa.entity;

/**
 * @Author Tianhao Tao
 * @Date 2020/9/9 16:49
 * @Version 1.0
 */
public class Department {
    private Long departmentId;
    private String departmentName;

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
