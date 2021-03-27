package com.knight.springboot.redis;


import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Component
public class RedisSimpleLock {

    private final StringRedisTemplate stringRedisTemplate;


    public boolean lock(String key, int lockHoldSecond) {
        if (stringRedisTemplate.hasKey(key)) {
            return false;
        }
        stringRedisTemplate.opsForValue().set(key, "", lockHoldSecond, TimeUnit.SECONDS);

        return true;
    }

    public void releaseLock(String key) {
        stringRedisTemplate.delete(key);
    }
}
