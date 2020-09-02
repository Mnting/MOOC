package com.imooc.oa.dao;

import com.imooc.oa.entity.User;
import com.imooc.oa.utils.MybatisUtils;

/**
 * @Author Tianhao Tao
 * @Date 2020/9/2 10:54
 * @Version 1.0
 */
public class UserDao {
    /**
     * 按用户名查询用户表
     * @param username 用户名
     * @return User对象包含对应的信息，null则代表对象不存在
     */
    public User selectByUsername(String username) {
        User user = (User) MybatisUtils.executeQuery(sqlSession -> sqlSession.selectOne("userMapper.selectByUsername", username));
        return user;
    }
}