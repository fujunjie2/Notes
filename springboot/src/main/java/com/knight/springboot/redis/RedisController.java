package com.knight.springboot.redis;


import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
@RequiredArgsConstructor
public class RedisController {

    private final RedisDemoService redisDemoService;

    private final StringRedisTemplate redisTemplate;

    @GetMapping("/get/{key}")
    public String getValue(@PathVariable("key") String key){
        return redisTemplate.opsForValue().get(key);
    }

    @GetMapping("/tryLockMethod")
    public void tryLockMethod() throws Exception{
        System.out.println("------------------------收到请求");
        redisDemoService.lock();
    }
}
