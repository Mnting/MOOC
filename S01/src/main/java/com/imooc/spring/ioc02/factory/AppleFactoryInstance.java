package com.imooc.spring.ioc02.factory;

/**
 * @Author Tianhao Tao
 * @Date 2020/10/18 22:13
 * @Version 1.0
 */

import com.imooc.spring.ioc02.entity.Apple;

/**
 * 工厂实例方法创建对象是指IoC容器对工厂类进行实例化
 * 并调用对应的实例方法创建对象的过程
 */
public class AppleFactoryInstance {
    public Apple createSweetApple(){
        Apple apple = new Apple();
        apple.setColor("red");
        apple.setTitle("红富士");
        apple.setOrigin("欧洲");
        return apple;
    }
}
