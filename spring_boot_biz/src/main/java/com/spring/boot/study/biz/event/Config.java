package com.spring.boot.study.biz.event;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-03-19 19:58
 **/
@Configurable
public class Config {

    @Bean
    public EmailNotifier emailNotifier() {
        return new EmailNotifier ();
    }
}
