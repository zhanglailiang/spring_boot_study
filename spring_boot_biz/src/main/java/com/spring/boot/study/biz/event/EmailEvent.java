package com.spring.boot.study.biz.event;

import org.springframework.context.ApplicationEvent;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-03-19 19:51
 **/
public class EmailEvent extends ApplicationEvent {

    private String address;

    private String text;

    public EmailEvent(Object source, String address, String text) {
        super (source);
        this.address = address;
        this.text = text;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public EmailEvent(Object source) {
        super (source);
    }
}
