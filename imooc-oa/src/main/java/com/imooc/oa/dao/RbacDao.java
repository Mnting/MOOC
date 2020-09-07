package com.imooc.oa.dao;

import com.imooc.oa.entity.Node;
import com.imooc.oa.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Author Tianhao Tao
 * @Date 2020/9/7 11:30
 * @Version 1.0
 */
public class RbacDao {
    /**
     *
     * @param userId
     * @return node对象包含对应的信息，null则代表对象不存在
     */
    public List<Node> selectNodeByUserId(Long userId){
        return (List<Node>)MybatisUtils.executeQuery(sqlSession->sqlSession.selectList("rbacMapper.selectNodeByUserId",userId));
    }
}
