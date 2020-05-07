package com.spring.boot.study.biz.proxy;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2020-03-12 14:29
 **/
public class Zhanglailiang implements Man {

    @Override
    public void findObject() {
        System.out.println ("hi my name is zhanglailiang");
    }
}
