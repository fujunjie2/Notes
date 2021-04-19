package com.knight.springboot.LoadSpecificClass;

import lombok.Data;

@Data
public class DynamicTaskEntity {

    String taskName;

    String cron;
}
