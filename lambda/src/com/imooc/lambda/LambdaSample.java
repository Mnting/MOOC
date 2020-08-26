package com.imooc.lambda;

public class LambdaSample {
    public static void main(String[] args) {
        /**
         * 约束条件：Lambda表达式只能实现有且只有一个抽象方法的接口，Java成为“函数式接口”
         */
        //1.标准使用方式
        MathOperation addition = (Integer a,Integer b) ->{
            System.out.println("加法运算");
            return a+b+0f;
        };
        System.out.println(addition.operate(5, 3));
        /**
         * 传统方式伪代码
         * class Addition implements MathOperation{
         * @Override
         * public Float operate(Integer a,Integer b){
         *      System.out.println("加法运算");
         *      return a+b+0f;
         * }
         *
         * Addition addition = new Addition();
         * System.out.println(addition.operate(3,5));
         */

        //2.Lambda允许忽略参数类型
        MathOperation substraction = (a,b) ->{
            System.out.println("减法运算");
            return a-b+0f;
        };
        System.out.println(substraction.operate(5, 3));

        //3.单行实现代码可以省略大括号和return
        MathOperation multiplication = (a,b) -> a*b+0f;
        System.out.println(multiplication.operate(5, 3));

        //4.若接口只有一个参数，小括号也可省略
//        MathOperation sample = a -> a*a+0f;
//        System.out.println(multiplication.operate(5));
    }
}
