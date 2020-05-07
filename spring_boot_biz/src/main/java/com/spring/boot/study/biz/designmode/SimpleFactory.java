package com.spring.boot.study.biz.designmode;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @program: spring_boot_study
 * @description: 简单工厂
 * @author: zhanglailiang
 * @create: 2020-05-06 10:17
 **/
public class SimpleFactory {

    public static Ball createBall(String name){
        if (name.equals("basketball")){
            return new BasketBall();
        }else if(name.equals("soccer")){
            return new Soccer();
        }else {
            return null;
        }
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Ball soccer = SimpleFactory.createBall("soccer");
        Ball basketBall = SimpleFactory.createBall("basketball");
        System.out.println(soccer.create()); //give you a soccer
        System.out.println(basketBall.create()); //give you a basketBall

        try {
            long time = System.currentTimeMillis ();
            CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "f1";
            });

            CompletableFuture f3 = CompletableFuture.runAsync(() -> {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return "f2";
            });

            CompletableFuture.allOf (f1, f2, f3).join ();
            String s = f1.get ();
            System.out.println (System.currentTimeMillis () - time);
        } catch (InterruptedException e) {
            System.out.println (111);
            e.printStackTrace ();
        } catch (RuntimeException e) {
            System.out.println (333);
            e.printStackTrace ();
        } catch (ExecutionException e) {
            System.out.println (222);
            e.printStackTrace ();
        }
    }

}


interface Ball {
    String create();
}

class Soccer implements Ball {
    @Override
    public String create() {
        return "give you a soccer";
    }
}

class BasketBall implements Ball {
    @Override
    public String create() {
        return "give you a basketBall";
    }
}



