package com.imooc.spring.ioc03.bookshop.service;

import com.imooc.spring.ioc03.bookshop.dao.BookDAO;

/**
 * @Author Tianhao Tao
 * @Date 2020/10/20 17:35
 * @Version 1.0
 */
public class BookService {
    private BookDAO bookDAO;

    public BookDAO getBookDAO() {
        return bookDAO;
    }

    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public void purchase(){
        System.out.println("正在执行图书采购业务方法！");
        bookDAO.insert();
    }
}
