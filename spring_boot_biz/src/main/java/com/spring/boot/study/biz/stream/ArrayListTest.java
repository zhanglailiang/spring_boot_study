package com.spring.boot.study.biz.stream;

import java.util.ArrayList;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2020-01-02 15:41
 **/
public class ArrayListTest {

    public static void main(String[] args) {
        ArrayList as = new ArrayList ();
        ArrayList as1 = new ArrayList ();
        for (int i = 0; i < 100 ; i++) {
            as.add (111);
            as.add (123);
            as.add (234);
            as.add (345);

            as1.add (111);
            as1.add (123);
            as1.add (234);
            as1.add (345);
        }

        as.hashCode ();
        System.out.println (as.equals (as1));

    }
}
