package com.knight.springboot.service;


import com.knight.springboot.pojo.vo.NamedVo;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    public NamedVo getNameVo() {
        return new NamedVo().setCity(1)
                .setId(2)
                .setCounty(2);
    }
}
