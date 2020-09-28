package com.imooc.oa.dao;

import com.imooc.oa.entity.ProcessFlow;

import java.util.List;

/**
 * @Author Tianhao Tao
 * @Date 2020/9/26 19:04
 * @Version 1.0
 */
public interface ProcessFlowDao {
    public void insert(ProcessFlow processFlow);

    public void update(ProcessFlow processFlow);

    public List<ProcessFlow> selectByFormId(Long formId);
}
