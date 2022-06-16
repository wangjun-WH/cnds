package com.example.cnds.jdk8.threadlocal;

/**
 * @author : wangjun
 * @date : 2021/11/4  20:27
 */
public class Work implements Runnable{
    String name;

    public String getName() {
        return name;
    }

    public Work(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println("执行了："+name+":"+Thread.currentThread().getName());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
