package com.spring.boot.study.biz.concurrent;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-03-11 01:25
 **/
public class TimeTask implements Delayed {

    private String yy;

    public String getYy() {
        return yy;
    }

    public void setYy(String yy) {
        this.yy = yy;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return 0;
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}
