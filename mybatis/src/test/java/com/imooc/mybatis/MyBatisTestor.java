package com.imooc.mybatis;

import com.imooc.mybatis.entity.Goods;
import com.imooc.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.net.ConnectException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//单元测试类
public class MyBatisTestor {
    @Test
    public void testSqlSessionFactory() throws Exception {
        //利用Reader加载classpath下的mybatis-config.xml核心配置文件
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        //初始化SqlSessionFactory对象，同时解析mybatis-config.xml文件
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        System.out.println("SessionFactory加载成功");
        //创建SqlSession对象,SqlSession是JDBC的扩展类，用于数据湖库交互
        SqlSession sqlSession = null;
        try {
            sqlSessionFactory.openSession();
            //创建数据库连接Connection仅用作测试用;
            // 使用Mybatis会自动创建，无需显示创建;
            // 尽量做到不引入jdbc相关类，如java.sql.connection;
            Connection connection = sqlSession.getConnection();
            System.out.println(connection);
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if(sqlSession != null){
                //在mybatis-config.xml中
                //如果type=“POOLED”，代表使用连接池，close则是将链接回收到连接池中
                //如果type=“UNPOOLED”，代表直连，close则会调用Connection.close()方法关闭连接
                sqlSession.close();
            }
        }
    }
    @Test
    public void testSelectAll() throws Exception{
        SqlSession sqlSession = null;
        try{
            sqlSession = MyBatisUtils.openSession();
            List<Goods> list = sqlSession.selectList("goods.selectAll");
            for(Goods g : list){
                System.out.println(g.getTitle());
            }
        }catch (Exception e){
            throw e;
        }finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testSelectById() throws Exception{
        SqlSession sqlSession = null;
        try{
            sqlSession = MyBatisUtils.openSession();
            Goods good = sqlSession.selectOne("goods.selectById",1602);
            System.out.println(good.getTitle());
        }catch (Exception e){
            throw e;
        }finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void  () throws Exception{
        SqlSession sqlSession = null;
        try{
            sqlSession = MyBatisUtils.openSession();
            Map param = new HashMap();
            param.put("min",100);
            param.put("max",500);
            param.put("limit",10);
            List<Goods> list = sqlSession.selectList("selectByPriceRange",param);
            for(Goods g:list) {
                System.out.println(g.getTitle()+":"+g.getCurrentPrice());
            }
        }catch (Exception e){
            throw e;
        }finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }
}
