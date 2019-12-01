package com.spring.boot.study.biz;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-05-20 09:43
 **/
public class Test {

  

    public static Test1 doChange() {
        Test1 test1 = new Test1 ("111");
        try {
            return test1;
        } catch (Exception e) {

        } finally {
            test1 = new Test1 ("222");
        }
        return test1 = new Test1 ("333");
    }

    static class Test1 {
        String name;

        public Test1(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Test1{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
