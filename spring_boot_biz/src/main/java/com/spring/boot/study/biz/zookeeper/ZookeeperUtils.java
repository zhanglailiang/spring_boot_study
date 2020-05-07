package com.spring.boot.study.biz.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2020-03-13 12:08
 **/
public class ZookeeperUtils {

    public static ZooKeeper getZookeeperConn(String address) throws IOException {
        String connectString = address;
        int sessionTimeout = 600000; // 会话超时时间
        System.out.println("zookeeper connecting 。。。。。。");
        // 监听器
        ZooKeeper zooKeeper = new ZooKeeper(connectString, sessionTimeout, event -> System.out.println("事件被触发了 --- {" + event.getState() + "} ---， 在这里我们可以做一些事情！！！"));
        System.out.println("zookeeper connection success!");
        return zooKeeper;
    }
}
