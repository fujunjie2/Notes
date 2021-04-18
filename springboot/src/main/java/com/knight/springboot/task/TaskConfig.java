package com.knight.springboot.task;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Component
public class TaskConfig implements ApplicationRunner {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        TaskScanner scanner = new TaskScanner(applicationContext);

        List<Class> classes = scanner.loadClassFilterByAnnotation("com.knight.springboot.task", DynamicTaskService.class);

        List<Method> taskMethod = new ArrayList<>(32);

        for (Class cla : classes) {
            Method[] methods = cla.getDeclaredMethods();

            for (Method method : methods) {
                if (method.isAnnotationPresent(DynamicTask.class)) {
                    DynamicTask dynamicTask = method.getAnnotation(DynamicTask.class);

                    String taskName = dynamicTask.taskName();
                    String cron = dynamicTask.cron();

                    System.out.println(taskName + " ---" + cron);

                }
            }
        }


    }
}
