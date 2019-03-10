package com.netty.study.demo;

public class DaemoDemo {

    public static void main(String[] args) {
        long startTime  = System.nanoTime();
        Thread  t = new Thread(()->{
            try {
                Thread.sleep(Long.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"daemo-thread");

        t.start();

        System.out.println("dd");
    }
}
