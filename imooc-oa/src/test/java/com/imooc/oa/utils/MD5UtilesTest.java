package com.imooc.oa.utils;

import junit.framework.TestCase;

/**
 * @Author Tianhao Tao
 * @Date 2020/9/9 23:32
 * @Version 1.0
 */
public class MD5UtilesTest extends TestCase {

    public void testMd5Digest1() {
        System.out.println(MD5Utiles.md5Digest("test"));
    }

    public void testMd5Digest2() {
        System.out.println(MD5Utiles.md5Digest("test",181));
    }
}