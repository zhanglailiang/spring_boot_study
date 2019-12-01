package com.spring.boot.study.biz.aop;


public interface Interceptor {

    boolean before();

    void after();

    Object around(Invocation invocation) throws Throwable;
}
