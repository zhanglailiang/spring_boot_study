package com.spring.boot.study.biz.concurrent;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-04-08 17:30
 **/
public class CacheLRU {

    public static void main(String[] args) {

        //指定缓存最大容量为4
        Map<Integer, Integer> map = new LRULinkedHashMap<> (4);
        map.put (9, 3);
        map.put (7, 4);
        map.put (5, 9);
        map.put (3, 4);
        map.put (6, 6);
        //总共put了5个元素，超过了指定的缓存最大容量
        //遍历结果
        for (Iterator<Map.Entry<Integer, Integer>> it = map.entrySet ().iterator (); it.hasNext (); ) {
            System.out.println (it.next ().getKey ());
        }
    }
}

class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    private int capacity;

    private static final long serialVersionUID = 1L;

    public LRULinkedHashMap(int capacity) {
        super (16, 0.75f, true);
        this.capacity = capacity;
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size () > capacity;
    }

}