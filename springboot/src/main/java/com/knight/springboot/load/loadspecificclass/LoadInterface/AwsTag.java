package com.knight.springboot.load.loadspecificclass.LoadInterface;

import org.springframework.stereotype.Component;

@Component
public class AwsTag implements Tag{
    @Override
    public String name() {
        return "awsTag";
    }
}
