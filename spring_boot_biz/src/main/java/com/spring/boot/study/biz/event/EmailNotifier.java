package com.spring.boot.study.biz.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-03-19 19:52
 **/
@Component
public class EmailNotifier implements ApplicationListener<EmailEvent> {
    @Override
    public void onApplicationEvent(EmailEvent emailEvent) {
        System.out.println (emailEvent.getAddress ());
    }
}
