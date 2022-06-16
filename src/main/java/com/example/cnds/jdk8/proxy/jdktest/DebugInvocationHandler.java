package com.example.cnds.jdk8.proxy.jdktest;

import com.example.cnds.jdk8.proxy.staticTest.SmsService;
import com.example.cnds.jdk8.proxy.staticTest.SmsServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author : wangjun
 * @date : 2021/11/2  20:21
 */
public class DebugInvocationHandler implements InvocationHandler {
    /**
     * 代理类中的真实对象
     */
    private final Object target;

    public DebugInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk动态代理前");
        Object invoke = method.invoke(target, args);
        System.out.println("jdk动态代理后");
        return invoke;
    }

    public static void main(String[] args) {
        SmsService smsService = (SmsService)JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("java");
        smsService.sign("sss");
    }
}
