package com.example.cnds.jdk8;

/**
 * @author : wangjun
 * @date : 2022/1/6  16:56
 */
public class RunnerTest implements Runnable{

    private Object lock1;
    private Object lock2;

    public RunnerTest(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {

    }
}
