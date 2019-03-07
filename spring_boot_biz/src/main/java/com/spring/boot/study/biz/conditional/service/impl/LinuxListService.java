package com.spring.boot.study.biz.conditional.service.impl;

import com.spring.boot.study.biz.conditional.service.ListService;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-03-07 20:48
 **/
public class LinuxListService implements ListService {

    @Override
    public String showListCmd() {
        return "ls";
    }
}
