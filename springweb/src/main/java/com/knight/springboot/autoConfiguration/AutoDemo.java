package com.knight.springboot.autoConfiguration;


import org.springframework.context.annotation.Configuration;

@Configuration
public class AutoDemo {

    static {
        System.out.println("\nconfiguration\n");
    }
}
