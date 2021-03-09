package com.klxx.api.utils.jackson.testpojo;

import lombok.Data;

import java.util.List;

@Data
public class VoBean<T> {

    private Integer status;

    private String name;

    private List<T> results;
}
