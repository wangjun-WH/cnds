package com.example.cnds.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

/**
 * @author : wangjun
 * @date : 2021/10/19  11:42
 */

public class ExecutorServiceSubmit {

    public static void testSubmit() throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Double> cf = executorService.submit(() -> {
            System.out.println("子线程-" + Thread.currentThread().getName() + "start");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(true){
                throw new RuntimeException("test");
            }else{
                System.out.println("子线程-" + Thread.currentThread().getName() + "end");
                return 1.2;
            }

        });

        System.out.println("main thread start,time->" + System.currentTimeMillis());
        //等待子任务执行完成,如果已完成则直接返回结果
        //如果执行任务异常，则get方法会把之前捕获的异常重新抛出
        System.out.println("run result->" + cf.get());
        System.out.println("main thread exit,time->" + System.currentTimeMillis());
    }


    public static void supplyAsyncTest() throws Exception{
        CompletableFuture<Double> cf= CompletableFuture.supplyAsync(()->{
            System.out.println("子线程-" + Thread.currentThread().getName() + "start");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(false){
                throw new RuntimeException("test");
            }else{
                System.out.println("子线程-" + Thread.currentThread().getName() + "end");
                return 1.2;
            }
        });
        System.out.println("main thread start,time->" + System.currentTimeMillis());
        //等待子任务执行完成,如果已完成则直接返回结果
        //如果执行任务异常，则get方法会把之前捕获的异常重新抛出
        System.out.println("run result->" + cf.get());
        System.out.println("main thread exit,time->" + System.currentTimeMillis());
    }


    public static void runAsyncTest() throws Exception{
        CompletableFuture cf =  CompletableFuture.runAsync(()->{
            System.out.println("子线程-" + Thread.currentThread().getName() + "start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(false){
                throw new RuntimeException("test");
            }else{
                System.out.println("子线程-" + Thread.currentThread().getName() + "end");
            }
        });
        System.out.println("main thread start,time->" + System.currentTimeMillis());
        //等待子任务执行完成,如果已完成则直接返回结果
        //如果执行任务异常，则get方法会把之前捕获的异常重新抛出
        System.out.println("run result->" + cf.get());
        System.out.println("main thread exit,time->" + System.currentTimeMillis());
    }


    public static void forkJoinPoolTest() throws Exception{
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(() -> {
            System.out.println("子线程-" + Thread.currentThread().getName() + "start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("子线程-" + Thread.currentThread().getName() + "end");
            return 1.5;
        }, forkJoinPool);
        System.out.println("main thread start,time->" + System.currentTimeMillis());
        //等待子任务执行完成,如果已完成则直接返回结果
        //如果执行任务异常，则get方法会把之前捕获的异常重新抛出
        System.out.println("run result->" + cf.get());
        System.out.println("main thread exit,time->" + System.currentTimeMillis());
    }

    public static void normalPoolTest() throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(() -> {
            System.out.println("子线程-" + Thread.currentThread().getName() + "start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程-" + Thread.currentThread().getName() + "end");
            return 1.5;
        }, executorService);
        System.out.println("main thread start,time->" + System.currentTimeMillis());
        //等待子任务执行完成,如果已完成则直接返回结果
        //如果执行任务异常，则get方法会把之前捕获的异常重新抛出
        System.out.println("run result->" + cf.get());
        System.out.println("main thread exit,time->" + System.currentTimeMillis());
    }

  public static void completableFutureTest() throws Exception {
      ExecutorService executorService = Executors.newSingleThreadExecutor();
      CompletableFuture<Double> cf = CompletableFuture.supplyAsync(() -> {
          System.out.println(Thread.currentThread()+" start job1,time->"+System.currentTimeMillis());
          try {
              Thread.sleep(2000);
          } catch (InterruptedException e) {
          }
          System.out.println(Thread.currentThread()+" exit job1,time->"+System.currentTimeMillis());
          return 1.2;
      }, executorService);

      CompletableFuture<String> cf2 = cf.thenApplyAsync((result) -> {
          System.out.println(Thread.currentThread() + " start job2,time->" + System.currentTimeMillis());
          try {
              Thread.sleep(2000);
          } catch (InterruptedException e) {
          }
          System.out.println(Thread.currentThread() + " exit job2,time->" + System.currentTimeMillis());
          return "test:" + result;
      });

      System.out.println("main thread start cf.get(),time->"+System.currentTimeMillis());
      //等待子任务执行完成
      System.out.println("run result->"+cf.get());
      System.out.println("main thread start cf2.get(),time->"+System.currentTimeMillis());
      System.out.println("run result->"+cf2.get());
      System.out.println("main thread exit,time->"+System.currentTimeMillis());
    }

    public static void thenTest() throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            return "cf1";
        }, executorService);

        cf.thenApply((result) -> {
            return result + "thenApply" + "---" + Thread.currentThread().getName();
        }).thenAccept((result) -> {
            System.out.println("thenAccept:" + result + "---" + Thread.currentThread().getName());
        }).thenRun(() -> {
            System.out.println("thenRun:" + "---" + Thread.currentThread().getName());
        });
    }


    public static void thenTest1() throws Exception {
        // 创建异步执行任务:
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " start job1,time->" + System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread() + " exit job1,time->" + System.currentTimeMillis());
            return 1.2;
        });
        CompletableFuture<Double> cf2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " start job2,time->" + System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread() + " exit job2,time->" + System.currentTimeMillis());
            return 3.2;
        });
        //cf和cf2的异步任务都执行完成后，会将其执行结果作为方法入参传递给cf3,且有返回值
        CompletableFuture<Double> cf3 = cf.applyToEither(cf2, (result) -> {
            System.out.println(Thread.currentThread() + " start job3,time->" + System.currentTimeMillis());
            System.out.println("job3 param result->" + result);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread() + " exit job3,time->" + System.currentTimeMillis());
            return result;
        });

        //cf和cf2的异步任务都执行完成后，会将其执行结果作为方法入参传递给cf3,无返回值
        CompletableFuture cf4 = cf.acceptEither(cf2, (result) -> {
            System.out.println(Thread.currentThread() + " start job4,time->" + System.currentTimeMillis());
            System.out.println("job4 param result->" + result);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread() + " exit job4,time->" + System.currentTimeMillis());
        });

//        //cf4和cf3都执行完成后，执行cf5，无入参，无返回值
//        CompletableFuture cf5 = cf4.runAfterEither(cf3, () -> {
//            System.out.println(Thread.currentThread() + " start job5,time->" + System.currentTimeMillis());
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//            }
//            System.out.println("cf5 do something");
//            System.out.println(Thread.currentThread() + " exit job5,time->" + System.currentTimeMillis());
//        });

        System.out.println("main thread start cf.get(),time->" + System.currentTimeMillis());
        //等待子任务执行完成
        System.out.println("cf run result->" + cf.get());
        System.out.println("main thread start cf5.get(),time->" + System.currentTimeMillis());
//        System.out.println("cf5 run result->" + cf5.get());
        System.out.println("main thread exit,time->" + System.currentTimeMillis());
    }



    //  public static void thenTest() throws Exception {
//
//    }
    public static void main(String[] args) throws Exception{
//        testSubmit();
//        supplyAsyncTest();
//        runAsyncTest();
//        forkJoinPoolTest();
//        normalPoolTest();
//        completableFutureTest();
//        thenTest();
        thenTest1();







    }




}
