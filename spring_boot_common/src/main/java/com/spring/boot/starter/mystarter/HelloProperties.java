package com.spring.boot.starter.mystarter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-05-22 09:35
 **/
@ConfigurationProperties(prefix = "javaboy")
public class HelloProperties {
    private static final String DEFAULT_NAME = "江南一点雨";
    private static final String DEFAULT_MSG = "牧码小子";
    private String name = DEFAULT_NAME;
    private String msg = DEFAULT_MSG;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}