package com.knight.springboot.name;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class NameAspect {

    // 1: 为什么这个注解使用这个执行范围后, around只执行了一次
//    @Pointcut("(@within(org.springframework.stereotype.Service) || @within(org.springframework.stereotype.Repository)) && execution((*) *(..))")
//    public void pointcut(){}

    // 这个织入范围, spring直接启动失败
//    @Pointcut("execution((*) *(..))")
//    public void pointcut(){}

//
//    @Pointcut("execution(* com.knight.springboot.service.DemoService.getNameVo())")
//    public void pointcut(){}

    @Pointcut("(@within(org.springframework.stereotype.Service) || @within(org.springframework.stereotype.Repository)) && execution((*) *(..))")
    public void pointcut(){}


    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("------------------ssb");
        Object result = joinPoint.proceed();
        System.out.println("------------------ssa");
        return result;
    }
}
