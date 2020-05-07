package com.spring.boot.study.test;

import java.util.concurrent.*;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2020-04-09 13:46
 **/
public class PoolTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        ExecutorService executorService = Executors.newWorkStealingPool ();
//        executorService.submit (() -> "123");

//        SynchronousQueue<Integer> q = new SynchronousQueue<> (true);
//        q.take ();
//        Integer peek = q.peek ();
//        System.out.println (peek);
//        Integer poll = q.poll ();
//        System.out.println (poll);

        long start = System.currentTimeMillis ();
        System.out.println (start);
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync (() -> {
            try {
                Thread.sleep (3000);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
            return "Hello";
        }).thenCombine (CompletableFuture.supplyAsync (() -> {
            try {
                Thread.sleep (2000);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
            return "world2";
        }), (s1, s2) -> s1 + " " + s2).thenCombine (CompletableFuture.supplyAsync (() -> {
                    try {
                        Thread.sleep (2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace ();
                    }
                    return "world3";
                }), (s1, s2) -> s1 + " " + s2);


        try {
            System.out.println (11);
            System.out.println(stringCompletableFuture.get (4, TimeUnit.SECONDS));
            System.out.println (System.currentTimeMillis () - start);
        } catch (TimeoutException e) {
            e.printStackTrace ();
        }

    }



}
