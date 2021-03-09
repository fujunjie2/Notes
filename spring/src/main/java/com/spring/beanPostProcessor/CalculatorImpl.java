package com.spring.beanPostProcessor;


import org.springframework.stereotype.Component;

@Component
public class CalculatorImpl implements Calculator {
    public void add(int a, int b) {
        System.out.println(a + b);
    }

    public void minus(int a, int b) {
        System.out.println(a - b);
    }
}
