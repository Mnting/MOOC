package com.imooc.oa.service;/**
 * @Author Tianhao Tao
 * @Date 2020/9/2 11:06
 * @Version 1.0
 */

import com.imooc.oa.dao.UserDao;
import com.imooc.oa.entity.User;
import com.imooc.oa.service.exception.BussinessException;
import javafx.application.Application;
import javafx.stage.Stage;

public class UserService{
    private UserDao userDao = new UserDao();

    /**
     * 根据前台输入进行登录校验
     * @param username 前台输入的用户名
     * @param password 前台输入的密码
     * @return 校验通过后，包含对应用户数据的User实体类
     * @throws BussinessException L001-用户不存在，L002密码错误
     */
    public User checkLogin(String username,String password){
        User user = userDao.selectByUsername(username);
        if (user == null) {
            //抛出用户不存在异常
            throw new BussinessException("L001", "用户名不存在");
        }
        if (!password.equals(user.getPassword())) {
            throw new BussinessException("L002", "密码不正确");
        }
        return user;
    }
}
