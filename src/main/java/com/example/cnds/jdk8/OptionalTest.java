package com.example.cnds.jdk8;

import java.util.Optional;

/**
 * @author : wangjun
 * @date : 2021/10/22  9:45
 */
public class OptionalTest {
    public static void main(String[] args) {
        Optional op= Optional.empty();
        String ss = null;
        String sss = "sss";
        Optional op1= Optional.of(sss);
        Optional op2= Optional.ofNullable(ss);

        System.out.println("op"+op.orElse("wwww"));
        System.out.println("op1"+op1.get());
        System.out.println("op2"+op2.orElse(null));

        if(op.isPresent()){
            //存在
        }

        op1.ifPresent(s-> System.out.println("真的有数据"));


    }

    public static void print(String s){





    }
}
