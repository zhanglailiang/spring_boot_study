package com.spring.boot.study.biz.aop.impl;

import com.spring.boot.study.biz.aop.HelloService;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-03-31 18:31
 **/
public class HelloServicImpl implements HelloService {

    @Override
    public void sayHello(String name) {
        System.out.println ("hello world");
    }
}
