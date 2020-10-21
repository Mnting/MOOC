package com.imooc.spring.ioc03.bookshop.dao;

/**
 * @Author Tianhao Tao
 * @Date 2020/10/21 14:37
 * @Version 1.0
 */
public class BookOracleDAOImpl implements BookDAO{
    public void insert() {
        System.out.println("向Oracle插入数据！");
    }
}
