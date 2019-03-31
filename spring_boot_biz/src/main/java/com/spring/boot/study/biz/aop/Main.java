package com.spring.boot.study.biz.aop;

import com.spring.boot.study.biz.aop.impl.HelloServicImpl;
import com.spring.boot.study.biz.aop.impl.MyInterceptor;
import com.spring.boot.study.biz.aop.proxy.ProxyBean;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-03-31 18:49
 **/
public class Main {

    public static void main(String[] args) {
        HelloService helloService =  new HelloServicImpl ();
        HelloService proxy = (HelloService) ProxyBean.getProxyBean (helloService, new MyInterceptor ());

        proxy.sayHello ("zhanglailiang");
    }
}
