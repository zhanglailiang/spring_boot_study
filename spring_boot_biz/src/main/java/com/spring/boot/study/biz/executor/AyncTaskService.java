package com.spring.boot.study.biz.executor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @program: spring_boot_study
 * @description: 执行类
 * @author: zhanglailiang
 * @create: 2019-03-07 20:23
 **/
@Service
public class AyncTaskService {

    @Async
    public void executeAsncTask(Integer i){
        System.out.println ("执行任务" + i);
    }

    @Async
    public void executeAsncTaskPlus(Integer i){
        System.out.println ("执行plus任务" + i);
    }
}
