package com.knight.springboot.redis;


import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

@Aspect
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@RequiredArgsConstructor
public class RedisLockAspect {

    private final RedisSimpleLock redisSimpleLock;

    @Pointcut("@annotation(com.knight.springboot.redis.UseRedisLock)")
    public void lockAspect(){}



    @Around("lockAspect()")
    public Object doAspect(ProceedingJoinPoint joinPoint) throws Throwable{

        Object target = joinPoint.getTarget();

        MethodSignature signature = (MethodSignature)joinPoint.getSignature();

        String methodName = signature.getName();

        Method method = target.getClass().getMethod(methodName, signature.getParameterTypes());

        UseRedisLock annotation = method.getAnnotation(UseRedisLock.class);

        String lockKey = getLockKey(joinPoint, annotation, method);

        Object ret;
        try {
            if (!tryLock(lockKey, annotation)) {
                throw new Exception("系统繁忙，请稍后");
            }
            ret =  joinPoint.proceed();
        } finally {
            redisSimpleLock.releaseLock(lockKey);
        }


        return ret;
    }


    public boolean tryLock(String key, UseRedisLock annotation) throws InterruptedException {
        for (int i = 0; i < annotation.retryTime(); i++) {
            System.out.println("正在尝试获取锁， 次数" + i);
            if (redisSimpleLock.lock(key, annotation.maxHoldSeconds())) {
                System.out.println("获取到锁");
                return true;
            } else {
                Thread.sleep(annotation.retryInterval());
            }
        }
        return false;
    }


    public String getLockKey(ProceedingJoinPoint joinPoint, UseRedisLock lock, Method method) throws Exception{
        String prefix = lock.prefix();
        RedisKeyType keyType = lock.keyType();

        if (keyType == RedisKeyType.USE_METHOD) {
            return prefix + method.getName();
        } else if (keyType == RedisKeyType.NONE) {
            return prefix + lock.key();
        } else if (keyType == RedisKeyType.USE_PARAM) {
            Parameter[] parameters = method.getParameters();

            for (int i=0; i<parameters.length; i++) {
                if (parameters[i].isAnnotationPresent(LockKeyParam.class)) {
                    Object arg = joinPoint.getArgs()[i];
                    if (arg instanceof String || arg instanceof Integer) {
                        return prefix + arg;
                    }
                } else {
                    throw new Exception("未找到Redis key");
                }
            }
        }

        return prefix;
    }

}
