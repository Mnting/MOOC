package com.imooc.oa.test;

import com.imooc.oa.utils.MybatisUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Tianhao Tao
 * @Date 2020/9/1 10:32
 * @Version 1.0
 */
@WebServlet(name = "TestServlet",urlPatterns = "/test")
public class TestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result = (String)MybatisUtils.executeQuery(sqlSession -> sqlSession.selectOne("test.sample"));
        request.setAttribute("result", result);
        request.getRequestDispatcher("/test.ftl").forward(request, response);
    }
}
