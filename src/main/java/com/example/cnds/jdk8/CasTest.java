package com.example.cnds.jdk8;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : wangjun
 * @date : 2021/10/26  20:02
 */
public class CasTest {
    private static volatile Integer size = 0;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    private static void increaseNum() {
        size++;
    }

    public static void main(String[] args) throws Exception {
        int maxSize = 20;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 1000, TimeUnit.SECONDS, new LinkedBlockingDeque<>(100));
        CountDownLatch countDownLatch = new CountDownLatch(maxSize);
        for (int i = 0; i < maxSize; i++) {
            threadPoolExecutor.submit(() -> {
                for (int j = 0; j < 10000; j++) {
                    increaseNum();
                    atomicInteger.incrementAndGet();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();

        System.out.println("size:" + size + "&&atomicInteger:" + atomicInteger.get());
        threadPoolExecutor.shutdown();
    }
}
