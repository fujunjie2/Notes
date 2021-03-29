package com.knight.springboot.lucene.service;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.knight.springboot.entity.ExpressMessage;
import com.knight.springboot.mapper.ExpressMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpressService {

    private final ExpressMapper expressMapper;

    public ExpressMessage findById(Integer id) {
        return expressMapper.selectById(id);
    }

    public List<ExpressMessage> findList() {
        QueryWrapper<ExpressMessage> queryWrapper = Wrappers.emptyWrapper();

        return expressMapper.selectList(queryWrapper);
    }
}
