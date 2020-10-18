package com.imooc.spring.ioc02.factory;

import com.imooc.spring.ioc02.entity.Apple;

/**
 * @Author Tianhao Tao
 * @Date 2020/10/18 22:04
 * @Version 1.0
 */
public class AppleStaticFactory {
    /**
     * 静态工厂通过静态方法创建对象，隐藏创建对象的细节
     * @return
     */
    public static Apple createSweetApple(){
        Apple apple = new Apple();
        apple.setColor("red");
        apple.setTitle("红富士");
        apple.setOrigin("欧洲");
        return apple;
    }
}
