package com.example.cnds.jdk8.threadlocal;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author : wangjun
 * @date : 2021/11/4  15:44
 */
@Slf4j
public class LocalModel {

    static ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 111;
        }
    };

    static ThreadLocal<String> stringThreadLocal = ThreadLocal.withInitial(() -> "222");


    public static Integer getIntegerThreadLocal() {
        return integerThreadLocal.get();
    }

    public static void setIntegerThreadLocal(Integer integerThread) {
        integerThreadLocal.set(integerThread);
    }

    public static String getStringThreadLocal() {
        return stringThreadLocal.get();
    }

    public static void setStringThreadLocal(String stringThread) {
        stringThreadLocal.set(stringThread);
    }


    public static void remove() {
        stringThreadLocal.remove();
        integerThreadLocal.remove();
    }


    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            int j = i;
//            new Thread(() -> {
//                LocalModel.setIntegerThreadLocal(j);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName() + ":" + LocalModel.getIntegerThreadLocal());
//                LocalModel.remove();
//            }, "线程" + i).start();
//        }
//
//        //核销线程数和最大线程数一样   阻塞队列无限大  容易oom
//        ExecutorService executorService = Executors.newFixedThreadPool(100);
//        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
//
//        //最大线程 无限大
//        ExecutorService executorService2 = Executors.newCachedThreadPool();
//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("pre" + "-%d")
                .setDaemon(true).build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>(2), new NamingThreadFactory("xxx"), new MyRejectPolicy());

        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.submit(new Work("标记"+i));
        }
//
//        log.info("=========================");
//        log.info("ThreadPool Size: [{}]", threadPoolExecutor.getPoolSize());
//        log.info("Active Threads: {}", threadPoolExecutor.getActiveCount());
//        log.info("Number of Tasks : {}", threadPoolExecutor.getCompletedTaskCount());
//        log.info("Number of Tasks in Queue: {}", threadPoolExecutor.getQueue().size());
//        log.info("=========================");

        threadPoolExecutor.shutdown();
        if (threadPoolExecutor.isTerminated()) {
            System.out.println("都执行完了");
        }
    }


}
