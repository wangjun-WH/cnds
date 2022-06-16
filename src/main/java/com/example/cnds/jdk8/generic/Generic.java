package com.example.cnds.jdk8.generic;

/**
 * @author : wangjun
 * @date : 2021/11/1  15:21
 */
public class Generic<T> {

    private T t;

    public Generic(T t) {
        this.t = t;
    }

    public T getKey(){
        return t;
    }

}
