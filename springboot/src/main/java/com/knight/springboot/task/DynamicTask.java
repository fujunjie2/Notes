package com.knight.springboot.task;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DynamicTask {


    String cron();

    String taskName();

}
