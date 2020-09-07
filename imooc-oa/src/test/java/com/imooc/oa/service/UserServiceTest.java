package com.imooc.oa.service;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @Author Tianhao Tao
 * @Date 2020/9/2 14:39
 * @Version 1.0
 */
public class UserServiceTest {

    private UserService userService = new UserService();

    @Test
    public void testCheckLogin1() {
        userService.checkLogin("uu", "123");
    }
    @Test
    public void testCheckLogin2() {
        userService.checkLogin("m8", "test");
    }
    @Test
    public void testCheckLogin3() {
        userService.checkLogin("m8", "1234");
    }

    @Test
    public void testSelectNodeByUserId(){
        System.out.println(userService.selectNodeByUserId(2l));
    }
}