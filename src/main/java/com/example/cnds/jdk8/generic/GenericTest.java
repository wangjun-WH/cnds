package com.example.cnds.jdk8.generic;

/**
 * @author : wangjun
 * @date : 2021/11/1  15:22
 */
public class GenericTest {
    public static void main(String[] args) {
        Generic<Integer> integerGeneric = new Generic<>(123456);
        System.out.println(integerGeneric.getKey());
        Integer[] int1 = {4,6,8,9};
        String[] sring1 = {"1","33","rrr"};
        prinArray(int1);
        prinArray(sring1);
        String ss="wwwww";
        Object o=new Object();
    }


    public static <E> void prinArray(E[] array) {
        for (E e : array) {
            System.out.println(e);
        }
    }

}
