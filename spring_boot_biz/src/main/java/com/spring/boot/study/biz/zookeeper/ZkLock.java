package com.spring.boot.study.biz.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @program: lvmm-fin-back
 * @description:
 * @author: zhanglailiang
 * @create: 2019-11-07 15:15
 **/
public class ZkLock {


    public static void main(String[] args) throws Exception {

        final String connectString = "106.14.149.231:2181";

        // 重试策略，初始化每次重试之间需要等待的时间，基准等待时间为1秒。
        RetryPolicy retryPolicy = new ExponentialBackoffRetry (1000, 3);

        // 使用默认的会话时间（60秒）和连接超时时间（15秒）来创建 Zookeeper 客户端
         CuratorFramework client = CuratorFrameworkFactory.builder().
                connectString(connectString).
                connectionTimeoutMs(15 * 1000).
                sessionTimeoutMs(60 * 100).
                retryPolicy(retryPolicy).
                build();

        // 启动客户端
        client.start();

        sharedReentrantLock (client);

//
//        final String lockNode = "/lock_node";
//        InterProcessMutex lock = new InterProcessMutex(client, lockNode);
//        try {
//            // 1. Acquire the mutex - blocking until it's available.
//            lock.acquire();
//
//            // OR
//
//            // 2. Acquire the mutex - blocks until it's available or the given time expires.
//            if (lock.acquire(60, TimeUnit.MINUTES)) {
//                Stat stat = client.checkExists().forPath(lockNode);
//                if (null != stat){
//                    // Dot the transaction
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace ();
//        } finally {
//            if (lock.isAcquiredInThisProcess()) {
//                lock.release();
//            }
//        }
    }


    public static void sharedReentrantLock(CuratorFramework client) throws Exception {
        // 创建共享锁
        final String lockNode = "/lock_node_reen";
        final InterProcessLock lock = new InterProcessMutex(client, lockNode);
        // lock2 用于模拟其他客户端
        final InterProcessLock lock2 = new InterProcessMutex(client, lockNode);

        final CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                // 获取锁对象
                try {
                    lock.acquire();
                    System.out.println("1获取锁===============");
                    // 测试锁重入
                    lock.acquire();
                    System.out.println("1再次获取锁===============");
                    Thread.sleep(5 * 1000);
                    lock.release();
                    System.out.println("1释放锁===============");
                    lock.release();
                    System.out.println("1再次释放锁===============");

                    countDownLatch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                // 获取锁对象
                try {
                    lock2.acquire();
                    System.out.println("2获取锁===============");
                    // 测试锁重入
                    lock2.acquire();
                    System.out.println("2再次获取锁===============");
                    Thread.sleep(5 * 1000);
                    lock2.release();
                    System.out.println("2释放锁===============");
                    lock2.release();
                    System.out.println("2再次释放锁===============");

                    countDownLatch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        countDownLatch.await();
    }
}
