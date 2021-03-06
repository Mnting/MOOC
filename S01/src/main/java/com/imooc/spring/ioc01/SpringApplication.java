package com.imooc.spring.ioc01;

import com.imooc.spring.ioc01.entity.Apple;
import com.imooc.spring.ioc01.entity.Child;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author Tianhao Tao
 * @Date 2020/10/16 17:27
 * @Version 1.0
 */
public class SpringApplication {
    public static void main(String[] args) {
        //创建Spring IoC容器，并根据配置文件在容器中实例化对象
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext01.xml");
        Apple sweetApple = context.getBean("sweetApple", Apple.class);
        System.out.println(sweetApple.getTitle());
        //从IoC容器中提取beanId = lily的对象
        Child lily = context.getBean("lily", Child.class);
        lily.eat();
    }
}




