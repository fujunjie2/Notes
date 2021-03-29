package com.knight.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.knight.springboot.entity.ExpressMessage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExpressMapper extends BaseMapper<ExpressMessage> {
}
