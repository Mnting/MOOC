package com.imooc.spring.ioc01;

import com.imooc.spring.ioc01.entity.Apple;
import com.imooc.spring.ioc01.entity.Child;

/**
 * @Author Tianhao Tao
 * @Date 2020/10/15 15:13
 * @Version 1.0
 */
public class Application {
    public static void main(String[] args) {
        Apple apple1 = new Apple("红富士","red","Europe");
        Apple apple2 = new Apple("青苹果","green","Asia");
        Apple apple3 = new Apple("黄元帅","yellow","China");
        Child lily = new Child("莉莉",apple1);
        Child andy = new Child("安迪",apple2);
        Child luna = new Child("露娜",apple3);
        lily.eat();
        andy.eat();
        luna.eat();
    }
}
