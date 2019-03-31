package com.spring.boot.study.biz.aop.impl;

import com.spring.boot.study.biz.aop.Interceptor;
import com.spring.boot.study.biz.aop.Invocation;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-03-31 18:36
 **/
public class MyInterceptor implements Interceptor {
    @Override
    public boolean before() {
        System.out.println ("before");
        return true;
    }

    @Override
    public void after() {
        System.out.println ("after");

    }

    @Override
    public Object around(Invocation invocation) throws Throwable {
        System.out.println ("around before");
        Object proceed = invocation.process ();
        System.out.println ("around after");
        return proceed;
    }
}
