package com.spring.boot.study.test.biz;

import com.spring.boot.study.biz.aopsourcestudy.HelloService;
import com.spring.boot.study.biz.aopsourcestudy.HelloService1;
import com.spring.boot.study.test.AbstractTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;

public class AopTest extends AbstractTest {

    @Autowired
    public HelloService helloService;

    @Autowired
    public HelloService1 helloService1;

    @Test
    public void testAop() {
        helloService.sayHello("1");

        helloService1.sayHello("2");


        Integer integer = Integer.valueOf ("01");

        new HashMap<String, String> () {{
            put ("ad","dd");
        }};

        new ArrayList<String> (){{
            add ("11");
        }};


    }
}
