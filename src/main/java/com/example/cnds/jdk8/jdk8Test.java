package com.example.cnds.jdk8;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author : wangjun
 * @date : 2022/1/6  17:48
 */
public class jdk8Test {
    public static void main(String[] args) {


        List<Integer> list = Arrays.asList(1, 2, 3, 6, 5);
        Collections.sort(list, (Integer o1, Integer o2) -> o1 - o2);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        Comparator<Integer> comparator1 = (Integer o1, Integer o2) -> o1 - o2;

        System.out.println(list);




        JButton button = new JButton();
        button.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                e.getItem();
            }
        });
        //lambda
        button.addItemListener(e -> e.getItem());



        excutes(new FunctionDemo() {
            @Override
            public void print() {
                System.out.println("啥也不说");
            }
        });


        excutes(()-> System.out.println("啥也不是"));


    }


    public static void excutes(FunctionDemo functionDemo) {
        functionDemo.print();
    }
}
