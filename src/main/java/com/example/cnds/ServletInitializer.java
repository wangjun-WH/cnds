package com.example.cnds;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CndsApplication.class);
    }

    public static void main(String[] args) {
        System.out.println(true || "a" == null ? false : true);
        System.out.println(true || ("a" == null ? false : true));
    }
}
