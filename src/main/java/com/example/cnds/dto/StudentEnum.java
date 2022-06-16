package com.example.cnds.dto;

/**
 * @author : wangjun
 * @date : 2021/10/19  20:25
 */
public enum StudentEnum {
    GOOD(1, "好的"),
    BAD(2, "坏的");
    private Integer scare;
    private String mark;

    StudentEnum(Integer scare, String mark) {
        this.scare = scare;
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }

    public Integer getScare() {
        return scare;
    }

}
