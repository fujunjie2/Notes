package com.knight.springboot.redis;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisDemoService {


    @UseRedisLock(key = "lock", keyType = RedisKeyType.USE_METHOD, retryTime = 3, retryInterval = 1000)
    public void lock() throws Exception{
        Thread.sleep(10000);
        System.out.println("------------");

    }
}
