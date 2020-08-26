package com.imooc.lambda;

import java.util.Random;
import java.util.function.Function;

/**
 * 利用Function函数式接口生成定长随机字符串
 */
public class FunctionSample {
    public static void main(String[] args) {
        Function<Integer,String> randomStringFunction = rsfLength -> {
          String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
          StringBuffer stringBuffer = new StringBuffer();
          Random random = new Random();
          for(int i = 0;i < rsfLength;i++){
              int position = random.nextInt(chars.length());
              stringBuffer.append(chars.charAt(position));
          }
          return stringBuffer.toString();
        };

        String randomString = randomStringFunction.apply(16);
        System.out.println(randomString);
    }
}
