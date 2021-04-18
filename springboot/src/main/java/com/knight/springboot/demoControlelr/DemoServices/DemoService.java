package com.knight.springboot.demoControlelr.DemoServices;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoService {


    public void simpleMethod() {
        System.out.println(this.getClass().getName());
    }

    @Transactional
    public void trancMethod() {
        System.out.println(this.getClass().getName());
    }
}
