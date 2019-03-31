package com.spring.boot.study.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {

    @RequestMapping("/user/hello")
    public String hello() {
        return "hello";
    }


    @RequestMapping("/admin/hello")
    public String adminHellolo() {
        return "hello";
    }
}
