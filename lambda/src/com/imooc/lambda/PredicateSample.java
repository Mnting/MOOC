package com.imooc.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateSample {
    public static void main(String[] args) {
        //函数式接口的调用
        Predicate<Integer> predicate = n->n>4;
        System.out.println(predicate.test(10));

        List<Integer> list  = Arrays.asList(1,2,3,4,5,6,7,8,9);
        //输出奇数传统方法
        for(Integer num:list){
            if(num%2==1){
                System.out.println(num);
            }
        }

        //输出奇数 利用函数式接口实现
        filter(list, n->n%2==1);
        //输出偶数 利用函数式接口实现
        filter(list, n->n%2==0);
        //输出大于5的偶数 利用函数式接口实现
        filter(list, n->n>5&&n%2==0);
    }

    public static void filter(List<Integer> list,Predicate<Integer> predicate){
        for(Integer num:list){
            if(predicate.test(num)){
                System.out.print(num+" ");
            }
        }
    }

}
