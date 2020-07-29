package com.imooc.mybatis;

import com.imooc.mybatis.dto.GoodsDTO;
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
    public void testSelectByPriceRange () throws Exception{
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

    @Test
    public void testSelectGoodsMapOrder () throws Exception{
        SqlSession sqlSession = null;
        try{
            sqlSession = MyBatisUtils.openSession();
            List<Map> list = sqlSession.selectList("goods.selectGoodsMapOrder");
            for(Map map:list) {
                System.out.println(map);
            }
        }catch (Exception e){
            throw e;
        }finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }
    @Test
    public void testSelectGoodsMapUnordered () throws Exception{
        SqlSession sqlSession = null;
        try{
            sqlSession = MyBatisUtils.openSession();
            List<Map> list = sqlSession.selectList("goods.selectGoodsMapUnordered");
            for(Map map:list) {
                System.out.println(map);
            }
        }catch (Exception e){
            throw e;
        }finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
        public void testSelectGoodsDTO () throws Exception{
        SqlSession sqlSession = null;
        try{
            sqlSession = MyBatisUtils.openSession();
            List<GoodsDTO> list = sqlSession.selectList("goods.selectGoodsDTO");
            for(GoodsDTO goodsDTO:list) {
                System.out.println(goodsDTO.getGoods().getTitle());
            }
        }catch (Exception e){
            throw e;
        }finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testInsert () throws Exception{
        SqlSession sqlSession = null;
        try{
            sqlSession = MyBatisUtils.openSession();
            Goods goods = new Goods();
            goods.setTitle("测试商品");
            goods.setSubTitle("测试子标题");
            goods.setOriginalCost(200f);
            goods.setIsFreeDelivery(1);
            goods.setCategoryId(43);
            goods.setDiscount(0.5f);
            goods.setCurrentPrice(100f);
            //insert()方法返回值代表本次成功插入的记录数
            int sum = sqlSession.insert("goods.insert",goods);
            sqlSession.commit();//提交事务数据
            System.out.println(sum);
            System.out.println(goods.getGoodsId());
        }catch (Exception e){
            if(sqlSession != null){
                sqlSession.rollback();//回滚事务
            }
        }finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testUpdate () throws Exception{
        SqlSession sqlSession = null;
        try{
            sqlSession = MyBatisUtils.openSession();
            Goods goods = sqlSession.selectOne("goods.selectById",739);
            goods.setTitle("更新测试商品");
            sqlSession.update("goods.update",goods);
            sqlSession.commit();
        }catch (Exception e){
            if(sqlSession != null){
                sqlSession.rollback();//回滚事务
            }
        }finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testDelete () throws Exception{
        SqlSession sqlSession = null;
        try{
            sqlSession = MyBatisUtils.openSession();
            int sum = sqlSession.delete("goods.delete",739);
            sqlSession.commit();
        }catch (Exception e){
            if(sqlSession != null){
                sqlSession.rollback();//回滚事务
            }
        }finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }
}
