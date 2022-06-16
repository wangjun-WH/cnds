package com.example.cnds.jdk8.proxy.staticTest;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : wangjun
 * @date : 2021/11/2  19:12
 */
@Slf4j
public class SmsProxy implements SmsService {

    private SmsService smsService;

    public SmsProxy(SmsService smsService) {
        this.smsService = smsService;
    }

    @Override
    public String send(String message) {
        System.out.println("代理前");
        String result = smsService.send("sss");
        System.out.println("代理后");
        return result;
    }

    @Override
    public String sign(String message) {
        return null;
    }

    public static void main(String[] args) {
        SmsProxy smsProxy= new SmsProxy(new SmsServiceImpl());
        smsProxy.send("我是代理");


    }
}
