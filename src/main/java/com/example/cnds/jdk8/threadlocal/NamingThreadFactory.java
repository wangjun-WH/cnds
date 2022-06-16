package com.example.cnds.jdk8.threadlocal;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : wangjun
 * @date : 2021/11/8  14:10
 */
public class NamingThreadFactory implements ThreadFactory {
    private AtomicInteger threadNum = new AtomicInteger(0);
    private String name;


    public NamingThreadFactory(String name) {
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t =new Thread(r);
        t.setName(name + " [#" + threadNum.incrementAndGet() + "]");
        return t;
    }
}
