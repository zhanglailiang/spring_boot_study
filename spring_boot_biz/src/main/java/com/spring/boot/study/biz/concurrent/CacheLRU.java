package com.spring.boot.study.biz.concurrent;

import java.util.*;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-04-08 17:30
 **/
public class CacheLRU {

    public static void main(String[] args) {

//        System.out.println ("321345".compareTo ("345321"));
//        char s = 's';
//        String ss = "1";
//        Set<String> data = new HashSet<> ();
//        System.out.println ((char)(s ^g 32));

//        //指定缓存最大容量为4
//        Map<Integer, Integer> map = new LRULinkedHashMap<> (4);
//        map.put (9, 3);
//        map.put (7, 4);
//        map.put (5, 9);
//        map.put (3, 4);
//        map.put (6, 6);
//        //总共put了5个元素，超过了指定的缓存最大容量
//        //遍历结果
//        for (Iterator<Map.Entry<Integer, Integer>> it = map.entrySet ().iterator (); it.hasNext (); ) {
//            System.out.println (it.next ().getKey ());
//        }

        Stack stack  = new Stack<Integer> ();
        System.out.println (Integer.valueOf (null));
        int ans  = 0;
        List<String> reslist = new ArrayList();
    }


    public int hammingWeight(int n) {
        int  a= 0,b= 0;
        int i = a & b;
        int count = 0;
        while(n!=0) {
            if ((n & 1) == 1)count++;
            n = n >>> 1;
        }
        return count;
    }
}

class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    private int cap;

    public LRULinkedHashMap(int cap) {
        super (16, 0.75f, true);
        this.cap = cap;
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return size () > cap;
    }
}