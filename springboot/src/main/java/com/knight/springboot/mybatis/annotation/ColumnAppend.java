package com.knight.springboot.mybatis.annotation;


import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ColumnAppend {

    String value();
}
