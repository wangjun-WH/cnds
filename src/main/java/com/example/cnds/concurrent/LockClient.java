package com.example.cnds.concurrent;

/**
 * @author : wangjun
 * @date : 2021/12/20  14:34
 */
public class LockClient {

    public synchronized void read() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行read");
    }

    public synchronized void read1() {
        System.out.println("执行read1");
    }


    public static void main(String[] args) {

        LockClient lockClient = new LockClient();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        lockClient.read();
                    }
                }).start();
            } else {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        lockClient.read1();
                    }
                }).start();
            }
        }

    }


}
