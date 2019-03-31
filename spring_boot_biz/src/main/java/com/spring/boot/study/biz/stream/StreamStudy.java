package com.spring.boot.study.biz.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-03-19 17:26
 **/
public class StreamStudy {

    public static void main(String[] args) {
        testCollet ();
    }


    public  static void testCollet() {

        // collect生成一个新的list
        List<String> s = Stream.of ("a", "b", "v").collect(Collectors.toList());

        // map将数据进行转换
        List<String> collect = s.stream ().map (str -> str.toUpperCase ()).collect (Collectors.toList ());

        // fitter进行数据过滤
        List<String> a = collect.stream ().filter (str -> Objects.equals (str, "a")).collect (Collectors.toList ());

        // flatMap 将两个stream 合成一个新的stream
        List<Integer> collect1 = Stream.of (asList (1, 2), asList (3, 4)).flatMap (numbers -> numbers.stream ()).collect (Collectors.toList ());

        // 取得最小值
        Integer s1 = collect1.stream ().min (Comparator.comparing (number -> number)).get ();

        // 取得最大值
        Integer s2 = collect1.stream ().max (Comparator.comparing (number -> number)).get ();


        // 实现从一组值中生成一个新值
        Integer reduce = collect1.stream ().reduce (0, (acc, ele) -> acc + ele);

//        collect1.stream ().sorted ().filter ()
        // 并行化流式处理 比 单式流程不一定好 要看数据量，如果数据量使用单式流程 如果数据量大 使用并发流

    }




}
