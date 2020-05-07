package com.spring.boot.study.test;

import lombok.SneakyThrows;

import java.io.IOException;
import java.util.concurrent.*;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2020-04-10 16:06
 **/
public class SumTask extends RecursiveTask<Integer> {

    private Integer start = 0;
    private Integer end = 0;

    public SumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @SneakyThrows
    @Override
    protected Integer compute() {

        if (end - start < 100) {
            //小于100时直接返回结果
            int sumResult = 0;
            for (int i = start; i <= end; i++) {
                sumResult += i;
            }
            return sumResult;
        } else {
            //大于一百时进行分割
            int middle = (end + start) / 2;
            SumTask leftSum = new SumTask(this.start, middle);
            SumTask rightSum = new SumTask(middle, this.end);
            System.out.println ("current_name:" + Thread.currentThread ().getName ());
            leftSum.fork();
            rightSum.fork();
            Thread.sleep (10);
            return leftSum.join() + rightSum.join ();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool executor = new ForkJoinPool(2);
        SumTask task = new SumTask(1, 9999999);

        ForkJoinTask future = executor.submit(task);
        try {
            System.out.println("result:" + future.get ());
        } catch (InterruptedException e) {
            e.printStackTrace ();
        } catch (ExecutionException e) {
            e.printStackTrace ();
        }

        Thread.sleep (1000);

        System.gc();
        System.runFinalization ();;
        System.gc ();

        try {
            System.in.read ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
}
