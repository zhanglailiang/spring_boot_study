package com.spring.boot.study.biz.aopsourcestudy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopAspect {


    @Around("execution (* com.spring.boot.study.biz.aopsourcestudy.HelloService.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {

        System.out.println("begin around");

        Object object = point.proceed();

        System.out.println("end around");

        return object;

    }

}

