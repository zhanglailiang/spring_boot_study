package com.spring.boot.study.biz.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.DelayQueue;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-03-11 01:24
 **/
public class TestConcurrent {


    public static void main(String[] args) {
        testArrayList();

        tesDelayQueue();
    }

    public static void testArrayList() {
        List<TimeTask> test = new ArrayList<> ();

        TimeTask task = new TimeTask ();
        test.add (task);
        test.add (task);
        test.add (task);
        test.add (task);
        test.add (task);
        test.add (task);

        System.out.println ("arrayLits_size:" + test.size ());
    }


    public static void tesDelayQueue() {
        DelayQueue<TimeTask> delayQueue = new DelayQueue<>();
        TimeTask task = new TimeTask ();
        delayQueue.add (task);
        delayQueue.add (task);
        delayQueue.add (task);
        delayQueue.add (task);
        delayQueue.add (task);
        delayQueue.add (task);
        System.out.println ("DelayQueue size:" + delayQueue.size ());
    }
}
