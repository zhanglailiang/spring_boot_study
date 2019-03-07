package com.spring.boot.study.biz.executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @program: spring_boot_study
 * @description: 任务执行器配置
 * @author: zhanglailiang
 * @create: 2019-03-07 20:20
 **/
@Configurable
@EnableAsync
@ComponentScan("com.spring.boot.study.biz.executor")
public class TaskExecutorConfig implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor ();
        taskExecutor.setCorePoolSize (5);
        taskExecutor.setMaxPoolSize (10);
        taskExecutor.setQueueCapacity (25);
        taskExecutor.initialize ();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }

}
