package com.knight.springboot.redis;

import java.lang.annotation.*;

/**
 * 使用方法参数中的 String 或则 Integer 参数作为 redis 中的 key
 */

@Documented
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface LockKeyParam {
}
