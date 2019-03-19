package com.spring.boot.study.biz.generator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: spring_boot_study
 * @description: Id生成器
 * @author: zhanglailiang
 * @create: 2019-03-11 11:25
 **/
public  class IdGenerator {



    /**
     * 队列最大的位数
     */
    private static int MAX_VALUE = 10000;


    /**
     * 队列
     */
    private ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<> ();


    /**
     * 公平0锁
     */
    private ReentrantLock lock = new ReentrantLock (true);


    public String generate20No() {
        SimpleDateFormat df = new SimpleDateFormat("yyMMddHHmmssSSS");//设置日期格式
        String formatTime = df.format(new Date ());// new Date()为获取当前系统时间，也可使用当前时间戳
        int id = generateId ();
        String machineId = getMachine ();
        String generateNo = formatTime + machineId + String.format("%04d", id);

        return generateNo;
    }


    private String getMachine() {
        return "101";
    }

    /**
     * id 自增序列号生成
     * @return
     */
    private int  generateId() {
        Integer id  = queue.poll ();
        if (id == null) {
            lock.lock ();
            try {
                while ((id = queue.poll()) == null){
                    offer();
                }
            } finally {
                lock.unlock ();
            }

        }
        return id;
    }

    private void offer() {
        for (int i = 0; i < MAX_VALUE; i++) {
            queue.offer (i);
        }
    }

    public static void main(String[] args) {

        final CountDownLatch latch = new CountDownLatch (100);
        Map nos = new ConcurrentHashMap ();
        IdGenerator idGenerator = new IdGenerator ();
        for (int i = 0; i < 100; i++) {
            new Thread (() -> {
                for (int j = 0; j < 100; j++) {
                    String no = idGenerator.generate20No ();
                    nos.put (no, "1");
                    System.out.println (idGenerator.generate20No ());
                }

                latch.countDown ();
            }).start ();
        }

        try {
            latch.await ();
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }

        System.out.println ("size:" + nos.keySet ().size ());

    }

}
