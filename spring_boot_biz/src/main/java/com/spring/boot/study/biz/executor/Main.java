package com.spring.boot.study.biz.executor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-03-07 20:25
 **/
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext (TaskExecutorConfig.class);

        AyncTaskService ayncTaskService = context.getBean (AyncTaskService.class);

        for (int i = 0; i < 10; i++) {
            ayncTaskService.executeAsncTask (i);
            ayncTaskService.executeAsncTaskPlus (i);
        }

        context.close ();
    }

}
