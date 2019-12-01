package com.spring.boot.study.biz.event;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-06-21 15:49
 **/
public class Test {

    public static void main(String[] args) {

        DelayQueue<Studuent> delayQueue = new DelayQueue<>();


        delayQueue.offer (new Studuent (System.currentTimeMillis () + 10000L , System.currentTimeMillis () +10000L));
        delayQueue.offer (new Studuent (System.currentTimeMillis () + 10000L , System.currentTimeMillis () +10000L));
        delayQueue.offer (new Studuent (System.currentTimeMillis () - 100000L , System.currentTimeMillis () +10000L));


//        delayQueue.poll ()

        /** 当前槽的过期时间 */
        AtomicLong expiration = new AtomicLong(-1L);
        long andSet = expiration.getAndSet (100L);
        System.out.println (andSet);
        System.out.println (expiration.getAndSet(100L) != 100L);
        System.out.println (expiration.getAndSet(100L) != 100L);



    }

}
