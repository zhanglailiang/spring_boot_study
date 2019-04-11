package com.spring.boot.study.biz.groovy;

import com.spring.boot.study.biz.groovy.bean.Rule;

public interface RuleEngine {

    void rule(Rule rule, Object object);
}
