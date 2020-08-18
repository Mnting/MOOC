package com.imooc.mybatis;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.imooc.mybatis.dto.GoodsDTO;
import com.imooc.mybatis.entity.Goods;
import com.imooc.mybatis.entity.GoodsDetail;
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
import java.util.*;

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
    public void testInsert   () throws Exception{
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

    @Test
    public void testDynamicSQL() throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            Map param = new HashMap();
            param.put("categoryId", 44);
            param.put("currentPrice", 500);
            //查询条件
            List<Goods> list = sqlSession.selectList("goods.dynamicSQL", param);
            for (Goods g : list) {
                System.out.println(g.getTitle() + ":" + g.getCategoryId() + ":" + g.getCurrentPrice());
            }
        }catch(Exception e){
            throw e;
        }finally{
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testLv1Cache() throws Exception{
        SqlSession sqlSession = null;
        try{
            sqlSession = MyBatisUtils.openSession();
            Goods goods = sqlSession.selectOne("goods.selectById",1603);
            Goods goods1 = sqlSession.selectOne("goods.selectById",1603);
            System.out.println(goods.getTitle());
            //由于默认开启了一级缓存（针对SqlSession），执行第二次重复操作的时候
            //系统判定缓存内已有查询结果，便直接将缓存对象赋给goods1，故两次hashCode完全相等
            System.out.println(goods.hashCode() + ":" + goods1.hashCode());
        }catch(Exception e){
            throw e;
        }finally {
            MyBatisUtils.closeSession(sqlSession);
        }

        try{
            sqlSession = MyBatisUtils.openSession();
            Goods goods = sqlSession.selectOne("goods.selectById",1603);
            Goods goods1 = sqlSession.selectOne("goods.selectById",1603);
            //由于默认开启了一级缓存（针对SqlSession）
            //前一个SqlSession已经关闭，此时相当于执行两个不同的会话
            //可以看到在同一个会话的相同操作hashcode相同
            //不同会话中的相同操作hashcode不同，也验证了一级缓存的生存周期只存在于一个sqlSession中
            System.out.println(goods.hashCode() + ":" + goods1.hashCode());
            //commit提交时对该namespace缓存强制清空
            sqlSession.commit();
            Goods goods2 = sqlSession.selectOne("goods.selectById",1603);
            System.out.println(goods2.hashCode());
        }catch(Exception e){
            throw e;
        }finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testLv2Cache() throws Exception{
        //在goods.xml中开启二级缓存后，缓存范围是命名空间namespace
        //缓存也不随sqlsession的关闭而清空，所以当执行两次相同操作时，第二次其实是在读取缓存
        SqlSession sqlSession = null;
        try{
            sqlSession = MyBatisUtils.openSession();
            Goods goods = sqlSession.selectOne("goods.selectById",1603);
            System.out.println(goods.hashCode());
        }catch(Exception e){
            throw e;
        }finally {
            MyBatisUtils.closeSession(sqlSession);
        }

        try{
            sqlSession = MyBatisUtils.openSession();
            Goods goods = sqlSession.selectOne("goods.selectById",1603);
            System.out.println(goods.hashCode() );
        }catch(Exception e){
            throw e;
        }finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testOneToMany() throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            List<Goods> list = sqlSession.selectList("goods.selectOneToMany");
            for (Goods goods : list) {
                System.out.println(goods.getTitle() + ":" + goods.getGoodsDetails().size());
            }
        }catch (Exception e){
            throw e;
        }finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testManyToOne() throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            List<GoodsDetail> list = sqlSession.selectList("goodsDetail.selectManyToOne");
            for (GoodsDetail goodsDetail : list) {
                System.out.println(goodsDetail.getGdPicUrl() + ":" + goodsDetail.getGoods().getTitle());
            }
        }catch (Exception e){
            throw e;
        }finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testSelectPage() throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            /* startPage方法会自动将下一次查询进行分页 */
            PageHelper.startPage(3,10);
            Page<Goods> page = (Page)sqlSession.selectList("goods.selectPage");
            System.out.println("总页数" + ":" + page.getPages());
            System.out.println("总记录数" + ":" + page.getTotal());
            System.out.println("开始行号" + ":" + page.getStartRow());
            System.out.println("结束行号" + ":" + page.getEndRow());
            System.out.println("当前页码" + ":" + page.getPageNum());
            List<Goods> data = page.getResult();//当前页数据
            for(Goods goods : data) {
                System.out.println(goods.getTitle());
            }
            System.out.println("");
        }catch (Exception e){
            throw e;
        }finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testBatchInsert() throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            List list = new ArrayList();
            long st = new Date().getTime();
        }catch (Exception e){
            throw e;
        }finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

}
