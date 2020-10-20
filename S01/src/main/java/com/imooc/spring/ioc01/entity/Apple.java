package com.imooc.spring.ioc01.entity;

/**
 * @Author Tianhao Tao
 * @Date 2020/10/15 15:07
 * @Version 1.0
 */
public class Apple {
    private String title;
    private String color;
    private String origin;

    public Apple() {
        System.out.println("已创建Apple对象"+this);
    }

    public Apple(String title, String color, String origin) {
        System.out.println("带参构造"+this);
        this.title = title;
        this.color = color;
        this.origin = origin;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
