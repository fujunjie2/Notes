package com.knight.springboot.load.loadonstartup;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class UsePostConstruct {


    @PostConstruct
    public void inits() {
        System.out.println("postConstruct_1");
    }
}
