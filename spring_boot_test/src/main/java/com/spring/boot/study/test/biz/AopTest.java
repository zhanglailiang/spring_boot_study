package com.spring.boot.study.test.biz;

import com.spring.boot.study.biz.aopsourcestudy.HelloService;
import com.spring.boot.study.biz.aopsourcestudy.HelloService1;
import com.spring.boot.study.test.AbstractTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AopTest extends AbstractTest {

    @Autowired
    public HelloService helloService;

    @Autowired
    public HelloService1 helloService1;

    @Test
    public void testAop() {
        helloService.sayHello("1");

        helloService1.sayHello("2");
    }
}
