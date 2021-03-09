package com.knight.springboot.pojo;

import lombok.Getter;

@Getter
public enum EnumCity {

    XM(1, "厦门"),
    BJ(2, "北京")

    ;



    private Integer id;

    private String name;

    EnumCity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
