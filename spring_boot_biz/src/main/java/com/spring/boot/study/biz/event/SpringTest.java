package com.spring.boot.study.biz.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-03-19 19:54
 **/
public class SpringTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext (Config.class);
        context.getBean (EmailNotifier.class);
        EmailEvent event = new EmailEvent ("hh", "1", "1");
        context.publishEvent (event);
    }

}
