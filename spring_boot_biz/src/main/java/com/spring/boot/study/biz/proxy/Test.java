package com.spring.boot.study.biz.proxy;

import java.lang.reflect.Proxy;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2020-03-12 14:35
 **/
public class Test {

    public static void main(String[] args) {
        Man man= new Zhanglailiang ();
        ManHandler manHandler = new ManHandler (man);

        Man manProxy = (Man) Proxy.newProxyInstance (Man.class.getClassLoader (), new Class[] {Man.class}, manHandler);
        manProxy.findObject ();
    }
}
