package com.spring.boot.study.biz.stream;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: spring_boot_study
 * @description: 学习aqs
 * @author: zhanglailiang
 * @create: 2019-09-15 14:14
 **/
public class StudyAQS {

    private static ReentrantLock lock = new ReentrantLock ();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                lock.lock();
                try {
                    lock.tryLock (1, TimeUnit.SECONDS);
                    lock.lockInterruptibly ();
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            });
            thread.start();
        }
    }

    public static void share(String[] args) {
        //设置信号量同时执行的线程数是5
        final Semaphore semp = new Semaphore(5);
        // 模拟20个客户端访问
        for (int index = 0; index < 20; index++) {
            final int NO = index;
            Runnable run = new Runnable() {
                public void run() {
                    try {
                        //使用acquire()获取锁
                        semp.acquire();
                        System.out.println("Accessing: " + NO);
                        //睡眠1秒
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                    }  finally {
                        //使用完成释放锁
                        semp.release();
                    }
                }
            };
        }
    }

}
