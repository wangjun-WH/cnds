package com.example.cnds.jdk8.proxy.cglib;

import com.example.cnds.jdk8.proxy.staticTest.SmsServiceImpl;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author : wangjun
 * @date : 2021/11/2  20:32
 */
public class CglibProxyFactory {

    public static Object getProxy(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(clazz.getClassLoader());
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new DebugMethodInterceptor());
        return enhancer.create();
    }

    public static void main(String[] args) {
        SmsServiceImpl smsService = new SmsServiceImpl();
        SmsServiceImpl smsService2= (SmsServiceImpl)CglibProxyFactory.getProxy(smsService.getClass());
        smsService2.send("hh");
    }

}
