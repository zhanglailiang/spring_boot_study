package com.spring.boot.study.biz.groovy.impl

import com.spring.boot.study.biz.groovy.bean.Rule
import com.spring.boot.study.biz.groovy.RuleEngine
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

import java.util.logging.Logger

@Component
class RuleEngineImpl  implements RuleEngine{

    Logger logger = LoggerFactory.getLogger(RuleEngineImpl.class)

    @Override
    void rule(Rule rule, Object object) {
        logger.info "executing rule"

        def exit = false

        rule.parameters.each {ArrayList params ->
            def paramIndex = 0
            def success  = true
            if (!exit) {
                rule.conditions.each {
                    logger.info "Condition Params index：" + paramIndex
                    success = success && it(object, paramIndex)
                    logger.info "Condition success:" + true
                    paramIndex++
                }
            }

            if (success && !exit) {
                rule.actions.each {
                    logger.info "Action params index:" + paramIndex
                    it(object, paramIndex)
                    paramIndex++
                }
            }

            if(rule.singlehit) {
                exit = true
            }
        }
    }
}
