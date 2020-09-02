package com.imooc.oa.entity;

/**
 * @Author Tianhao Tao
 * @Date 2020/9/2 10:40
 * @Version 1.0
 */
public class User {
    private Long userId;
    private String username;
    private String password;
    private Long employeeId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}
