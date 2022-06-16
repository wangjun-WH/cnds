package com.example.cnds.jdk8.threadlocal;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author : wangjun
 * @date : 2021/11/4  20:28
 */
public class MyRejectPolicy implements RejectedExecutionHandler {
    public MyRejectPolicy() {
    }

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        //Sender是我的Runnable类，里面有message字段
        if (r instanceof Work) {
            Work sender = (Work) r;
            //直接打印
            System.out.println("被丢弃了"+sender.getName());
        }
        System.out.println("被丢弃了");
    }
}
