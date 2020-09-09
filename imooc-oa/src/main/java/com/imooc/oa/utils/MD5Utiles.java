package com.imooc.oa.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @Author Tianhao Tao
 * @Date 2020/9/9 23:31
 * @Version 1.0
 */
public class MD5Utiles {
    public static String md5Digest(String source) {
        return DigestUtils.md5Hex(source);
    }

    /**
     * 对源数据加盐混淆后生成MD5摘要
     *
     * @param source 源数据
     * @param salt   盐值
     * @return MD5摘要
     */
    public static String md5Digest(String source, Integer salt) {
        char[] ca = source.toCharArray();
        for (int i = 0; i < ca.length; i++) {
            ca[i]=(char)(ca[i]+salt);
        }
        return DigestUtils.md5Hex(new String(ca));
    }

    public static void main(String[] args) {
        System.out.println(md5Digest("test",221));
    }
}
