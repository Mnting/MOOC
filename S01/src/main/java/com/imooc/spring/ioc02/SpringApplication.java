package com.imooc.spring.ioc02;

import com.imooc.spring.ioc.entity.Apple;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author Tianhao Tao
 * @Date 2020/10/18 20:21
 * @Version 1.0
 */
public class SpringApplication {
    public static void main(String[] args) {
        //初始化IoC容器并实例化对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Apple Apple1 = applicationContext.getBean("Apple1",Apple.class);
        System.out.println(Apple1.getTitle()+" "+Apple1.getOrigin()+" "+Apple1.getColor());
    }
}
