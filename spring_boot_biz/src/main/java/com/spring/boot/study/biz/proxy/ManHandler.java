package com.spring.boot.study.biz.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2020-03-12 14:31
 **/
public class ManHandler implements InvocationHandler {

    private Man man;


    public ManHandler(Man man) {
        this.man = man;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before ();
        method.invoke (man, null);
        after ();
        return null;
    }

    public void before() {
        System.out.println ("没找到之前");
    }

    public void after() {
        System.out.println ("找到之后");
    }

}
