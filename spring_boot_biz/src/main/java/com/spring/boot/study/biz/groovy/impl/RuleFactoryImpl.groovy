package com.spring.boot.study.biz.groovy.impl

import com.spring.boot.study.biz.groovy.RuleFactory
import com.spring.boot.study.biz.groovy.bean.Rule
import org.joda.time.DateTime
import org.joda.time.Years
import org.springframework.stereotype.Component


@Component
class RuleFactoryImpl implements RuleFactory {

    Closure  age = {birthday->
        return Years.yearsBetween(birthday, new DateTime()).getYears()
    }


    @Override
    Rule getAgeCategoryRule() {

        Rule rule = new Rule()
        rule.conditions = [{object, params -> age(object.birthDay) >= params},{object, params -> age(object.birthDay) <= params} ]
        rule.actions=[ {object, param->object. ageCategory = param}]
        rule parameters=[
                    [O , 10, 'Kid '],
                    [11 , 20 ,'Youth '],
                    [21 , 40 ,'Adult '],
                    [41, 60 , 'Matured '] ,
                    [61 , 80,'Middle aged '],
                    [81 ,120 ,'Old ']
        ]
        return rule
    }
}
