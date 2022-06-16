package com.example.cnds.jdk8.proxy.staticTest;

/**
 * @author : wangjun
 * @date : 2021/11/2  18:57
 */
public interface SmsService {
    String send(String message);

    String sign(String message);
}
