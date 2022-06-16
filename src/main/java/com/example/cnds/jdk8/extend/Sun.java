package com.example.cnds.jdk8.extend;

/**
 * @author : wangjun
 * @date : 2021/11/1  17:21
 */
public class Sun extends Father{
    private String love;

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love;
    }

    public static void main(String[] args) {
        Sun sun = new Sun();
        sun.setName("www");
        StringBuffer stringBuffer = new StringBuffer();
        Class<? extends StringBuffer> aClass = stringBuffer.getClass();
        Integer num=new Integer(999);
        num.hashCode();
    }
}
