package com.spring.beanPostProcessor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestPostProcessor {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(Config.class);

        String[] beanName = annotationConfigApplicationContext.getBeanDefinitionNames();


//        for (String beanDefinitionName : beanName) {
//            System.out.println(beanDefinitionName);
//        }

        Calculator calculator = (Calculator)annotationConfigApplicationContext.getBean(Calculator.class);

        calculator.minus(1, 2);


    }
}
