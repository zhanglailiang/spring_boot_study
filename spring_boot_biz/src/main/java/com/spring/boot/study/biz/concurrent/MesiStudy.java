package com.spring.boot.study.biz.concurrent;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2020-01-08 14:53
 **/
public class MesiStudy {

    private static  int size;
//    int  size = 0;


    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread (()->{
                for (int j = 0; j < 10000 ; j++) {
                    System.out.println (Thread.currentThread().getName() + ":" + (size++));
                }
            }).start ();
        }
    }





}
