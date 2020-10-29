package com.imooc.spring.ioc04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author Tianhao Tao
 * @Date 2020/10/27 10:06
 * @Version 1.0
 */
public class SpringApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ioc04/applicationContext.xml");
//        String[] ids = context.getBeanDefinitionNames();
//        for (String id : ids){
//            System.out.println(id);
//        }
    }
}
