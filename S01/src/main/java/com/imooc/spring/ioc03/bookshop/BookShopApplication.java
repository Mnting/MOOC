package com.imooc.spring.ioc03.bookshop;

import com.imooc.spring.ioc03.bookshop.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author Tianhao Tao
 * @Date 2020/10/20 21:31
 * @Version 1.0
 */
public class BookShopApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext03-*.xml");
        BookService bookService = context.getBean("bookService",BookService.class);
        bookService.purchase();
        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames){
            System.out.println(beanName);
        }
    }
}
