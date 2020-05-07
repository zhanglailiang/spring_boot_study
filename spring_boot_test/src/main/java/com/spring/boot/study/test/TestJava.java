package com.spring.boot.study.test;

import com.spring.boot.study.biz.event.EmailEvent;
import org.springframework.util.ReflectionUtils;
import sun.misc.Unsafe;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.atomic.LongAdder;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2020-03-16 17:23
 **/
public class TestJava {
    int i;


    public static void main(String[] args) {

        LongAdder longAdder = new LongAdder ();
        longAdder.increment ();;

        LinkedList  list = new LinkedList ();
        String s = KeyValue16 ();
        System.out.println (s);

//        ConcurrentHashMap child = new ConcurrentHashMap<> ();
//        child.put ("1", null);
//        child.computeIfAbsent("a",key -> {
//
//            child.put("a","v2");
//
//            return"v1";
//
//        });

//
//        new Thread(() -> { A a = new A();a.method(); }).start();
//        new Thread(() -> { A b = new A();b.method(); }).start();
//        try {
//            System.in.read ();
//        } catch (IOException e) {
//            e.printStackTrace ();
//        }

//        ConcurrentHashMap map = new ConcurrentHashMap ();
//        for (int i = 0; i < 20; i++) {
//            map.put ("1" + i, "wjsw");
//        }

//        ExecutorService executorService = Executors.newFixedThreadPool (1);
//
//        Field text = ReflectionUtils.findField (EmailEvent.class, "text");
//        Method getAddress = ReflectionUtils.findMethod (EmailEvent.class, "getAddress");
////        ReflectionUtils.invokeMethod (new EmailEvent (), getAddress);
//
//        System.out.println (text);
//        Deque<Integer> testDeque = new ArrayDeque<> ();
//        testDeque.offer (1);
//        testDeque.offer (2);
//        testDeque.offer (3);
//        testDeque.offer (4);
//        testDeque.offer (5);
//        testDeque.offerFirst (6);
//
//        Integer[] s = new  Integer[20];
//        for (int i = 0; i <s.length ; i++) {
//            System.out.println (s[i]);
//        }
//
//
//        ArrayList<String> data = new ArrayList<> ();
//        Iterator<String> iterator = data.iterator ();
//        while(iterator.hasNext ()) {
//            String next = iterator.next ();
//        }
//
//        LinkedList<String> data1 = new LinkedList<> ();
//        Iterator<String> iterator1 = data1.iterator ();
//        while(iterator1.hasNext ()) {
//            String next = iterator1.next ();
//        }

//        ArrayList<Integer>  s = new ArrayList<Integer> (){{
//            add (1);
//            add (1);
//            add (1);
//            add (1);
//            add (1);
//            add (1);
//        }};
//        ArrayList<Integer>  s1 = new ArrayList<Integer> (){{
//            add (1);
//            add (1);
//            add (1);
//            add (1);
//        }};
//        ArrayList<Integer>  s2 = new ArrayList<Integer> (){{
//            add (1);
//            add (1);
//            add (1);
//            add (1);
//            add (1);
//        }};
//
//        PriorityQueue<ArrayList> arrayLists = new PriorityQueue<> ((n1, n2) -> n1.size () - n2.size ());
//        arrayLists.add (s);
//        arrayLists.add (s1);
//        arrayLists.add (s2);
//        for (int i = 0; i < 3; i++) {
//            ArrayList poll = arrayLists.poll ();
//            System.out.println (poll.size ());
//        }




//        ConcurrentHashMap map = new ConcurrentHashMap ();
//        map.put ("不1", 1);
//        map.put ("不2", 2);
//        map.put ("不3", 3);
//
//        Set set =map.keySet ();
//        Iterator iterator = set.iterator ();
//        while (iterator.hasNext ()) {
//            System.out.println (iterator.next ());
//            map.put ("不4",4);
//            System.out.println ("长度：" + map.size ());
//        }
//
//        Integer[] nums = null;
//        List<String>   res = new ArrayList();
//
//        Arrays.sort (nums, (n1, n2)-> n2 - n1);
//
//        res.sort((s1, s2)->(s1+s2).compareTo(s2+s1));
//
//     List<String> s =new ArrayList ();
//        s.sort ((s1,s2)->s2.compareTo (s1));

    }

        /**生成32位的密钥**/
        public static String KeyValue32(){
            //定义一个字符串（A-Z，a-z，0-9）即62位；
            String str="zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
            //由Random生成随机数
            Random random=new Random();
            StringBuffer sb=new StringBuffer();
            //长度为几就循环几次
            for(int i=0; i<32; ++i){
                //产生0-61的数字
                int number=random.nextInt(62);
                //将产生的数字通过length次承载到sb中
                sb.append(str.charAt(number));
            }
            //将承载的字符转换成字符串
            return sb.toString();
        }

        /**生成16位的密钥**/
        public static String KeyValue16(){
            //定义一个字符串（A-Z，a-z，0-9）即62位；
            String str="zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
            //由Random生成随机数
            Random random=new Random();
            StringBuffer sb=new StringBuffer();
            //长度为几就循环几次
            for(int i=0; i<16; ++i){
                //产生0-61的数字
                int number=random.nextInt(62);
                //将产生的数字通过length次承载到sb中
                sb.append(str.charAt(number));
            }
            //将承载的字符转换成字符串
            return sb.toString();
        }


    public boolean isUnique(String astr) {
        int has = 0;
        // 利用位图算法，数可以互相转换的原理 这个使用时有限制的 因为int是32位的 如果是数字 是不能使用的 只能支持32位的长度
        for ( int i=0;i<astr.length();i++) {
            int bit  = 1<<(astr.charAt(i) - 'a');
            if ((bit&has) != 0 ) {
                return false;
            }
            has |= bit;
        }
        return true;
    }



}

class A {
    public synchronized void method() {/**/
        System.out.println ("in");
        try {
            Thread.sleep (10000);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        System.out.println ("end");

    }
}

