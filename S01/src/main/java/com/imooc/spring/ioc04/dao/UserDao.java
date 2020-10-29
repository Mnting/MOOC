package com.imooc.spring.ioc04.dao;

import org.springframework.stereotype.Repository;

/**
 * @Author Tianhao Tao
 * @Date 2020/10/26 10:32
 * @Version 1.0
 */
//组件类型注解默认beanId为类名首字母小写
    //beanId = userDao
//@Repository("udao")
@Repository
public class UserDao {
    public UserDao(){
        System.out.println("正在创建："+this);
    }
}
