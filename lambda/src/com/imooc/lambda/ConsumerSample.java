package com.imooc.lambda;

import java.util.function.Consumer;

/**
 * Consumer接口的使用
 */
public class ConsumerSample {
    public static void main(String[] args) {
        output(s-> System.out.println("向控制台打印:"+s));
    }
    public static void output(Consumer<String> consumer){
        String text = "函数式接口";
        consumer.accept(text);
    }
}
