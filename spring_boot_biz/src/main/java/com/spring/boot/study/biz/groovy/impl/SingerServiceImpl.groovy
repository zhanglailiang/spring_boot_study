package com.spring.boot.study.biz.groovy.impl

import com.spring.boot.study.biz.groovy.RuleEngine
import com.spring.boot.study.biz.groovy.RuleFactory
import com.spring.boot.study.biz.groovy.SingerService
import com.spring.boot.study.biz.groovy.bean.Rule
import com.spring.boot.study.biz.groovy.bean.Singer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Service

@Service
class SingerServiceImpl implements SingerService {


    @Autowired
    ApplicationContext context


    @Autowired
    private RuleFactory ruleFactory


    @Autowired
    private RuleEngine ruleEngine


    @Override
    void applyResult(Singer singer) {
        Rule rule = ruleFactory.getAgeCategoryRule()
        ruleEngine.rule(rule, singer)
    }
}
