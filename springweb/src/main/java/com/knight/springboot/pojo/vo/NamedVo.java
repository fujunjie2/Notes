package com.knight.springboot.pojo.vo;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class NamedVo {

    private Integer id;

    private Integer city;

    private String cityName;

    private Integer county;

    private String name;
}
