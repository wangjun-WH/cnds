package com.example.cnds.jdk8.enumTest;

/**
 * @author : wangjun
 * @date : 2021/11/2  16:20
 */
public class MainTest {
    public static void main(String[] args) {
        Pizza testPz = new Pizza();
        testPz.setStatus(Pizza.PizzaStatus.READY);
        testPz.isDeliverable();
    }
}
