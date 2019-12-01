package com.spring.boot.study.biz.datatime;

import java.time.Duration;
import java.time.Instant;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @program: shardjdbc-study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-07-26 10:23
 **/
public class Timeline {

    public static void main(String[] args) {
        Instant start = Instant.now ();
        runAlgorithm ();
        Instant end = Instant.now ();

        Duration timeElapsed = Duration.between (start, end);
        long millis = timeElapsed.toMillis ();
        System.out.println ("%d milliscecord");

        Instant start2 = Instant.now ();
    }

    public static void runAlgorithm() {
        int size = 10;
        List<Integer> list = new Random ().ints ().map (i->i%100).limit (size).boxed ().collect(Collectors.toList());
        Collections.sort (list);
        System.out.println (list);
    }

    public static void runAlgorithm2() {
        int size = 10;
        List<Integer> list = new Random ().ints ().map (i->i%100).limit (size).boxed ().collect(Collectors.toList());
        Collections.sort (list);
        System.out.println (list);
    }
}
