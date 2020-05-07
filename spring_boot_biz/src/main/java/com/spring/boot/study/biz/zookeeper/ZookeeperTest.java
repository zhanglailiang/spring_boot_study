package com.spring.boot.study.biz.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2020-03-13 12:07
 **/
public class ZookeeperTest {
    public static void main(String[] args) {
        try {

            ZooKeeper zooKeeper = ZookeeperUtils.getZookeeperConn("106.14.149.231:2181");
            if(zooKeeper != null) {

                System.out.println(zooKeeper.create("/father", "test node".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL));

                for (int i = 0; i < 100; i++) {
                    Stat stat1 = zooKeeper.setData("/father", new byte[0], -1);
                    System.out.println (stat1.getVersion());
                }


                Stat exists = zooKeeper.exists ("/father", event -> {
                    // 监听器
                    System.out.println("father事件被触发了 --- {" + event.getType() + "} ---， ");
                });

                // 1.1.创建zookeeper的znode

                zooKeeper.exists ("/father", event -> {
                    // 监听器
                    System.out.println("father事件被触发了 --- {" + event.getType () + "} ---， ");
                });


                // 1.2.重复创建节点
                // 1.4.创建一个序列节点(持久化节点)
                System.out.println(zooKeeper.create("/seq_node", "sequential".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL));
                // 1.5.创建一个只读节点
                System.out.println(zooKeeper.create("/ro_node", "read only node".getBytes(), ZooDefs.Ids.READ_ACL_UNSAFE, CreateMode.PERSISTENT));

                // 2.1获取子节点
                List<String> nodeList = zooKeeper.getChildren("/", false);
                for (String nodeName : nodeList) {
                    System.out.println(nodeName);
                }
                // 2.2.获取节点权限信息
                List<ACL> aclList = zooKeeper.getACL("/ro_node", new Stat ());
                for (ACL acl : aclList) {
                    System.out.println(acl);
                }

                // 2.3.查看节点数据
                byte[] data = zooKeeper.getData("/ro_node", false, new Stat());
                System.out.println(new String(data));
                // 2.4.获取客户端状态
                ZooKeeper.States states = zooKeeper.getState();

                // 删除前先获取节点的数据结构
                Stat stat = zooKeeper.exists("/seq_node0000000011", false);
                if(stat != null) {
                    // 3.1.version = -1 是删除所有版本的节点
                    zooKeeper.delete("/seq_node0000000011", stat.getVersion());
                    // 3.2.删除一个含有子节点的节点（KeeperErrorCode = Directory not empty for /app）
                    zooKeeper.delete("/app", -1);
                } else {
                    System.out.println("节点不存在！");
                }
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
