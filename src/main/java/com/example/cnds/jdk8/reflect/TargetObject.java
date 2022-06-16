package com.example.cnds.jdk8.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author : wangjun
 * @date : 2021/11/2  17:21
 */
public class TargetObject {
    private String value;

    public TargetObject() {
        value = "JavaGuide";
    }

    public void publicMethod(String s) {
        System.out.println("I love " + s);
    }

    private void privateMethod() {
        System.out.println("value is " + value);
    }


    public static void main(String[] args) throws Throwable {

        Class<?> aClass = Class.forName("com.example.cnds.jdk8.reflect.TargetObject");
        TargetObject o = (TargetObject) aClass.newInstance();

        for (Method method : aClass.getDeclaredMethods()) {
            System.out.println(method.getName());
        }

        Method publicMethod = aClass.getDeclaredMethod("publicMethod", String.class);
        publicMethod.invoke(o,"啥也不说");


        for (Field field:aClass.getDeclaredFields() ) {
            System.out.println(field.getName());
            field.setAccessible(true);
            field.set(o,"完犊子了");
        }
        o.privateMethod();

        Method privateMethod = aClass.getDeclaredMethod("privateMethod");
//        privateMethod.setAccessible(true);
        privateMethod.invoke(o);
    }
}
