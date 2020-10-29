package com.imooc.spring.ioc04.service;

import com.imooc.spring.ioc04.controller.UserController;
import org.springframework.stereotype.Service;

/**
 * @Author Tianhao Tao
 * @Date 2020/10/27 10:14
 * @Version 1.0
 */
@Service
public class UserService {
    public UserService(){
        System.out.println("正在创建："+this);
    }
}
