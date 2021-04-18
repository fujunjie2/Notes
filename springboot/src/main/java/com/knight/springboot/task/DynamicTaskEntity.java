package com.knight.springboot.task;

import lombok.Data;

@Data
public class DynamicTaskEntity {

    String taskName;

    String cron;
}
