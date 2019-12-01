package com.spring.boot.study.test;

import com.spring.boot.study.SpringBootStartupApplication;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 单元测试父类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootStartupApplication.class)
public class AbstractTest {
    protected static final Logger logger = LoggerFactory.getLogger (AbstractTest.class);

    static {
        // 设置使用环境
    }
}
