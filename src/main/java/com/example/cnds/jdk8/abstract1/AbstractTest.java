package com.example.cnds.jdk8.abstract1;

import com.example.cnds.jdk8.threadlocal.Work;

/**
 * @author : wangjun
 * @date : 2021/11/12  11:37
 */
public class AbstractTest {
    public static void main(String[] args) {
        new Line().draw();
        new Circle().draw();
    }
}


abstract class Shape {
    public abstract void draw();

    public void work(String name){
        System.out.println("我是打工的"+name);
    }
}

class Line extends Shape {
    @Override
    public void draw() {
        System.out.println("划直线");
        work("划直线");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("划圆形");
        work("划圆形");
    }
}