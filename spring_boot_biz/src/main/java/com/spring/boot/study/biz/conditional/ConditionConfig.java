package com.spring.boot.study.biz.conditional;

import com.spring.boot.study.biz.conditional.condition.LinuxCondition;
import com.spring.boot.study.biz.conditional.condition.WindowsCondition;
import com.spring.boot.study.biz.conditional.service.ListService;
import com.spring.boot.study.biz.conditional.service.impl.LinuxListService;
import com.spring.boot.study.biz.conditional.service.impl.WindowsListService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-03-07 20:50
 **/
@Configurable
public class ConditionConfig {

    @Bean
    @Conditional (WindowsCondition.class)
    public ListService windowsListService(){
        return new WindowsListService ();
    }

    @Bean
    @Conditional (LinuxCondition.class)
    public ListService liunxListService(){
        return new LinuxListService ();
    }
}
