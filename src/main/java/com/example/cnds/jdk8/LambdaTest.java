package com.example.cnds.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author : wangjun
 * @date : 2021/10/21  19:26
 */
public class LambdaTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }



    //Stream
    static void test3() {
        String[] array = {"aasw", "wwf", "fghh", "wwwg", "evrtey", "ad", "2", "sfsef", "wwwg"};
        List<String> list = Arrays.asList(array);
        list.stream().filter(s->s.length()>3).limit(3).forEach(System.out::println);
        list.stream().map(String::length).forEach(System.out::println);
        changeStr("啥也不说",(x)->System.out.println(x));
    }

    //函数式接口
    //Consumer 有参数无返回
    public static void changeStr(String str, Consumer<String> consumer){
        consumer.accept(str);
    }









    public static void test1() {
        Comparator<Integer> cpt1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        //由小到大排序
        TreeSet<Integer> set1 = new TreeSet<>(cpt1);

        System.out.println(set1);
        //使用lambda表达式
        Comparator<Integer> cpt2 = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> set2 = new TreeSet<>(cpt2);
    }


    public static void test2() {
        String[] array = {"aasw", "wwf", "fghh", "wwwg", "evrtey", "ad", "2", "sfsef", "wwwg"};
        List<String> list = Arrays.asList(array);
        List<String> newList = chooseList(list, x -> x.length() > 3);
        List<String> newList1 = chooseList1(() -> list, x -> x.length() > 3);
        List<String> newList2 = chooseList(list, new MyChoose<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 3;
            }
        });

        System.out.println(newList);
        System.out.println(newList1);
        System.out.println(newList2);
    }


    public static List<String> chooseList1(Supplier<List<String>> supplier, Function<String, Boolean> function) {
        List<String> newList = new ArrayList<>();
        supplier.get().stream().forEach(s -> {
            if (function.apply(s)) {
                newList.add(s);
            }
        });
        return newList;
    }


    public static List<String> chooseList(List<String> list, MyChoose<String> myChoose) {
        List<String> newList = new ArrayList<>();
        list.stream().forEach(s -> {
            if (myChoose.test(s)) {
                newList.add(s);
            }
        });
        return newList;
    }


}
