package main.java.com.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author Tianhao Tao
 * @Date 2020/10/28 15:13
 * @Version 1.0
 */

/**
 * 这个题是抄的大神题解@宝石
 * 对HashMap方法以及HashSet原理的的熟练运用
 * 值得学习~
 */
public class UniqueNumberofOccurrences1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> counter = new HashMap<>();
        for(int elem : arr){
            counter.put(elem,counter.getOrDefault(elem,0)+1);
        }
        return counter.size() == new HashSet<Integer>(counter.values()).size();
    }
}
