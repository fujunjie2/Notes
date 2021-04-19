package com.knight.springboot.LoadSpecificClass.LoadInterface;

import org.springframework.stereotype.Component;

@Component
public class AwsTag implements Tag{
    @Override
    public String name() {
        return "awsTag";
    }
}
