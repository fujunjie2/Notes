package com.knight.springboot.task;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DynamicTaskService {

    String appName() default "AWS";
}
