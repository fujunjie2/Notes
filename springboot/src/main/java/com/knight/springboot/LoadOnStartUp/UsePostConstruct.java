package com.knight.springboot.LoadOnStartUp;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class UsePostConstruct {


    @PostConstruct
    public void init() {
        System.out.println("postConstruct_1");
    }
}
