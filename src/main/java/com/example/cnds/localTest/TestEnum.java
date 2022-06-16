package com.example.cnds.localTest;

import com.example.cnds.dto.StudentEnum;

/**
 * @author : wangjun
 * @date : 2021/10/19  20:35
 */
public class TestEnum {
    public static void main(String[] args) {
        for (StudentEnum studentEnum : StudentEnum.values()) {
            System.out.println(studentEnum.getScare() + ":" + studentEnum.getMark());
        }
        StudentEnum temp = StudentEnum.valueOf("GOOD");
        System.out.println(temp.getScare() + ":" + temp.getMark());
    }


}
