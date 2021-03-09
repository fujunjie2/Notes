package com.knight.springboot.redis;

public enum RedisKeyType {


    NONE,

    /**
     * 参数作key
     */
    USE_PARAM,

    /**
     * 方法名为key
     */
    USE_METHOD;
}
