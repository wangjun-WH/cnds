package com.example.cnds.jdk8.proxy.staticTest;

/**
 * @author : wangjun
 * @date : 2021/11/2  18:58
 */
public class SmsServiceImpl implements SmsService {
    @Override
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }

    @Override
    public String sign(String message) {
        System.out.println("sign message:" + message);
        return message;
    }
}
