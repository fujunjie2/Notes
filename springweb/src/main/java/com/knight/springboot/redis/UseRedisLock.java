package com.knight.springboot.redis;


import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UseRedisLock {

    /**
     * 锁前缀
     */
    String prefix() default "LOCK#";

    /**
     *  key
     */
    String key() default "";


    RedisKeyType keyType() default RedisKeyType.NONE;

    /**
     *  竞争锁失败后重试次数
     */
    int retryTime() default 1;

    /**
     *  竞争锁失败后重试间隔
     */
    int retryInterval() default 0;

}
