package com.imooc.oa.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.function.Function;

public class MybatisUtils {
    //利用static（静态）属于类不属于对象，且全局唯一
    private static SqlSessionFactory sqlSessionFactory = null;

    //利用静态块在初始化类时实例化sqlSessionFactory
    static {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            //初始化错误时，通过抛出异常ExceptionInInitializerError通知调用者
            throw new ExceptionInInitializerError(e);
        }
    }

    //Function为函数式接口，在lambda表达式课程中有讲到
    /**
     * 执行SELECT查询SQL
     * @param function 要执行查询语句代码块
     * @return 查询结果
     */
    public static Object executeQuery(Function<SqlSession,Object> function) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            Object object = function.apply(sqlSession);
            return object;
        }finally {
            sqlSession.close();
        }
    }

    /**
     *  执行INSERT/UPDATE/DELETE写操作SQL
     * @param function 要执行的写操作代码块
     * @return 写操作后返回的结果
     */
    public static Object executeUpdate(Function<SqlSession,Object> function) {
        //autoCommit:false即为不自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        try {
            Object object = function.apply(sqlSession);
            sqlSession.commit();
            return object;
        }catch(RuntimeException e){
            sqlSession.rollback();
            throw e;
        }
        finally {
            sqlSession.close();
        }
    }
}
