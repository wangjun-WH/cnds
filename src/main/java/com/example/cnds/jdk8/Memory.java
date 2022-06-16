package com.example.cnds.jdk8;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : wangjun
 * @date : 2022/1/6  16:24
 */
public class Memory {
    public static void main(String[] args) {
        AtomicInteger num = new AtomicInteger(0);
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                System.out.println("第" + num.incrementAndGet() + "次");
                ThreadLocal<Byte[]> threadLocal = new ThreadLocal<Byte[]>();
                threadLocal.set(new Byte[1024 * 4096]);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                threadLocal.remove();
            }).start();
        }

    }
}
