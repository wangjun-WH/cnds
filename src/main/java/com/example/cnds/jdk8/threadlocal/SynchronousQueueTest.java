package com.example.cnds.jdk8.threadlocal;

import java.util.Random;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author : wangjun
 * @date : 2021/11/8  11:43
 */
public class SynchronousQueueTest {
    public static void main(String[] args) {
        SynchronousQueue<Integer> integers = new SynchronousQueue<>();

        new Thread(new Provder(integers),"provider").start();
        new Thread(new Consumer(integers),"consumer").start();


    }


   static class Provder implements Runnable{

        private SynchronousQueue<Integer> synchronousQueue;

        public Provder(SynchronousQueue<Integer> synchronousQueue) {
            this.synchronousQueue = synchronousQueue;
        }

        @Override
        public void run() {

            while (true) {
                    int rand = new Random().nextInt(1000);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronousQueue.offer(rand);
                    System.out.println(Thread.currentThread().getName()+"生成："+rand);
            }
        }
    }


    static class Consumer implements Runnable{
        private SynchronousQueue<Integer> synchronousQueue;

        public Consumer(SynchronousQueue<Integer> synchronousQueue) {
            this.synchronousQueue = synchronousQueue;
        }
        @Override
        public void run() {
            while (true) {
                try {
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"消费：" + synchronousQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }


        }
    }




}
