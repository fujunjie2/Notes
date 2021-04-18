package com.knight.springboot.task;

@DynamicTaskService(appName = "AWS")
public class AwsTask {

    @DynamicTask(cron = "1 2/4 0 0 0", taskName = "dfd")
    public void task() {
        System.out.println(1);
    }


}
