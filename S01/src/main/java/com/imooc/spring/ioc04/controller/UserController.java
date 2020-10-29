package com.imooc.spring.ioc04.controller;

import org.springframework.stereotype.Controller;

/**
 * @Author Tianhao Tao
 * @Date 2020/10/27 10:14
 * @Version 1.0
 */
@Controller
public class UserController {
    public UserController(){
        System.out.println("正在创建："+this);
    }
}
