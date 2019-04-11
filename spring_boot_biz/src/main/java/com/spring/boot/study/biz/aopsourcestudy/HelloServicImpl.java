package com.spring.boot.study.biz.aopsourcestudy;

import org.springframework.stereotype.Component;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-03-31 18:31
 **/
@Component
public class HelloServicImpl implements HelloService {

    @Override
    public void sayHello(String name) {
        System.out.println ("hello world");
    }
}
