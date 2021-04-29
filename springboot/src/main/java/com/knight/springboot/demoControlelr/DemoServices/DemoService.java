package com.knight.springboot.demoControlelr.DemoServices;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.knight.springboot.entity.Test;
import com.knight.springboot.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DemoService {

    @Autowired
    private TestMapper testMapper;

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    public void saveTest() {
        Test test = new Test();

        test.setStatus(Test.StatusEnum.INVALID);
        test.setPassword(String.valueOf(Math.random()));
        testMapper.insert(test);
    }

    public List<Test> getTest() {
        return testMapper.selectList(Wrappers.emptyWrapper());
    }

    public Test getTestC() {
        LambdaQueryWrapper<Test> query = new LambdaQueryWrapper<>();
        query.eq(Test::getId, 1);
        return testMapper.selectOne(Wrappers.emptyWrapper());
    }


    public void simpleMethod() {
        System.out.println(this.getClass().getName());
    }

    @Transactional
    public void trancMethod() {
        System.out.println(this.getClass().getName());
    }
}
