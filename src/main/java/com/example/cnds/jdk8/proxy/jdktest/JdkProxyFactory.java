package com.example.cnds.jdk8.proxy.jdktest;

import java.lang.reflect.Proxy;

/**
 * @author : wangjun
 * @date : 2021/11/2  20:23
 */
public class JdkProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new DebugInvocationHandler(target));
    }
}
