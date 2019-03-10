package com.spring.boot.study.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
