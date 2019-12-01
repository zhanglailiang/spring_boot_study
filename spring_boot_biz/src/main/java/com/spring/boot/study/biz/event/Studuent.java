package com.spring.boot.study.biz.event;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-06-21 15:50
 **/
public class Studuent implements Delayed {


    private long liveTime ;
    private long removeTime;

    public Studuent() {
    }

    public Studuent(long liveTime, long removeTime) {
        this.liveTime = liveTime;
        this.removeTime = removeTime;
    }

    public long getLiveTime() {
        return liveTime;
    }

    public void setLiveTime(long liveTime) {
        this.liveTime = liveTime;
    }

    public long getRemoveTime() {
        return removeTime;
    }

    public void setRemoveTime(long removeTime) {
        this.removeTime = removeTime;
    }

    @Override
    public int compareTo(Delayed o) {
        if (o == null) return 1;
        if (o == this) return  0;
        if (o instanceof Studuent){
            Studuent studuent = (Studuent)o;
            if (liveTime > studuent.liveTime ) {
                return 1;
            }else if (liveTime == studuent.liveTime) {
                return 0;
            }else {
                return -1;
            }
        }
        long diff = getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
        return diff > 0 ? 1:diff == 0? 0:-1;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(removeTime - System.nanoTime(), unit);
    }
}
