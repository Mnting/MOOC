package com.imooc.oa.controller;

import com.imooc.oa.entity.User;
import com.imooc.oa.service.UserService;
import com.imooc.oa.service.exception.BussinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Tianhao Tao
 * @Date 2020/9/2 15:05
 * @Version 1.0
 */
@WebServlet(name = "LoginServlet" ,urlPatterns = "/check_login")
public class LoginServlet extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(LoginServlet.class)
    private UserService userService = new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try{
            User user = userService.checkLogin(username, password);
        }catch (BussinessException e){
            logger.error(e.getMessage(),e);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
