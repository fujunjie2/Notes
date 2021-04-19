package com.knight.springboot.LoadSpecificClass;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DynamicTask {


    String cron();

    String taskName();

}
