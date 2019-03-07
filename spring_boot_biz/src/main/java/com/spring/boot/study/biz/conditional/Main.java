package com.spring.boot.study.biz.conditional;

import com.spring.boot.study.biz.conditional.service.ListService;
import com.spring.boot.study.biz.executor.TaskExecutorConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-03-07 20:51
 **/
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext (ConditionConfig.class);
        ListService listService = context.getBean (ListService.class);

        System.out.println (listService.showListCmd ());
    }
}
