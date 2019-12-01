package com.spring.boot.study.biz.stream;

import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-09-12 17:16
 **/
public class Test {


    public static void main(String[] args) throws InterruptedException {
//        Integer a  = 1;
//        Integer b  = 2;
//        Integer c  = 3;
//        Integer d  = 3;
//        Integer e  = 321;
//        Integer f  = 321;
//
//        Long g = 3L;
//
//        System.out.println (c == d);
//        System.out.println (e == f);
//        System.out.println (c == (a + b ));
//        System.out.println (c.equals (a + b ));
//        System.out.println (g ==  (a + b ));
//        System.out.println (g.equals (a + b ));
//
//        FooBar fooBar = new FooBar (10);
//            new Thread (()-> {
//                try {
//                    fooBar.bar (()-> System.out.println ("bar"));
//                } catch (InterruptedException e1) {
//                    e1.printStackTrace ();
//                }
//            }).start ();
//            new Thread (()-> {
//                try {
//                    fooBar.foo (()-> System.out.println ("foo"));
//                } catch (InterruptedException e1) {
//                    e1.printStackTrace ();
//                }
//            }).start ();
//
//        try {
//            System.in.read ();
//        } catch (IOException e1) {
//            e1.printStackTrace ();
//        }

//        BoundedBlockingQueue queue = new BoundedBlockingQueue (2);
//            new Thread (()-> {
//                try {
//                    queue.enqueue(1);
//                    System.out.println ("1:" +  queue.size ());
//                } catch (InterruptedException e) {
//                    e.printStackTrace ();
//                }
//            }).start ();   // 生产者线程将1插入队列。
//            new Thread (()-> {
//                try {
//                    queue.dequeue();
//                    System.out.println ("2:" + queue.size ());
//                } catch (InterruptedException e) {
//                    e.printStackTrace ();
//                }
//            }).start ();    // 消费者线程调用dequeue并返回1。
//            new Thread (()-> {
//                try {
//                    queue.dequeue();
//                    System.out.println ("3:" + queue.size ());
//                } catch (InterruptedException e) {
//                    e.printStackTrace ();
//                }
//            }).start ();    // 由于队列为空，消费者线程被阻塞。
//            new Thread (()-> {
//                try {
//                    queue.enqueue(0);
//                    System.out.println ("4:" + queue.size ());
//                } catch (InterruptedException e) {
//                    e.printStackTrace ();
//                }
//            }).start ();   // 生产者线程将0插入队列。消费者线程被解除阻塞同时将0弹出队列并返回。
//            new Thread (()-> {
//                try {
//                    queue.enqueue(2);
//                    System.out.println ("5:" + queue.size ());
//                } catch (InterruptedException e) {
//                    e.printStackTrace ();
//                }
//            }).start ();   // 生产者线程将2插入队列。
//            new Thread (()-> {
//                try {
//                    queue.enqueue(3);
//                    System.out.println ("6:" + queue.size ());
//                } catch (InterruptedException e) {
//                    e.printStackTrace ();
//                }
//            }).start ();   // 生产者线程将3插入队列。
//            new Thread (()-> {
//                try {
//                    queue.enqueue(4);
//                    System.out.println ("7:" + queue.size ());
//                } catch (InterruptedException e) {
//                    e.printStackTrace ();
//                }
//            }).start ();  // 生产者线程由于队列长度已达到上限2而被阻塞。
//            new Thread (()-> {
//                try {
//                    queue.dequeue();
//                    System.out.println ("8:" + queue.size ());
//                } catch (InterruptedException e) {
//                    e.printStackTrace ();
//                }
//            }).start ();   // 消费者线程将2从队列弹出并返回。生产者线程解除阻塞同时将4插入队列。
//            queue.size();       // 队列中还有2个元素。size()方法在每组测试用例最后调用。
//


        FizzBuzz fizzBuzz = new FizzBuzz (15);
        new Thread (()-> {
            try {
                fizzBuzz.buzz (()-> System.out.println ("buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }).start ();   // 生产者线程将3插入队列。
        new Thread (()-> {
            try {
                fizzBuzz.fizzbuzz (()-> System.out.println ("fizzbuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }).start ();  // 生产者线程由于队列长度已达到上限2而被阻塞。
        new Thread (()-> {
            try {
                fizzBuzz.fizz (()-> System.out.println ("fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }).start ();   // 消
        new Thread (()-> {
            try {
                fizzBuzz.number ((a)-> System.out.println (a));
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }).start ();   // 消


        while (true) {
            Thread.sleep (2000);

        }




    }


    class Foo {

        public Foo() {

        }

        Semaphore simaphore1 = new Semaphore(1);
        Semaphore simaphore2 = new Semaphore(0);
        Semaphore simaphore3 = new Semaphore(0);

        public void first(Runnable printFirst) throws InterruptedException {
            simaphore1.acquire (1);
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            simaphore2.release (1);
        }

        public void second(Runnable printSecond) throws InterruptedException {
            simaphore2.acquire (1);
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            simaphore3.release (1);

        }

        public void third(Runnable printThird) throws InterruptedException {
            simaphore3.acquire (1);
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run ();
            simaphore1.release (1);
        }

    }



}

class FooBar {
    private int n;

    Semaphore  semaphore = new Semaphore (1);
    Semaphore  semaphore1 = new Semaphore (0);


    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            semaphore.acquire (1);
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            semaphore1.release (1);
        }


    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            semaphore1.acquire (1);
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            semaphore.release (1);

        }

    }
}


class FooBar1 {
    private int n;

    Semaphore  semaphore = new Semaphore (1);
    Semaphore  semaphore1 = new Semaphore (0);


    public FooBar1(int n) {
        this.n = n;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            semaphore.acquire (1);
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            semaphore1.release (1);
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            semaphore1.acquire (1);
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            semaphore.release (1);

        }

    }
}


class H2O {

    public H2O() {

    }

    CyclicBarrier cyclibarrier  = new CyclicBarrier(3);
    Semaphore semaphore = new Semaphore (2);
    Semaphore semaphore1 = new Semaphore (1);

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        semaphore.acquire (1);
        try {
            cyclibarrier.await ();
        } catch (BrokenBarrierException e) {
            e.printStackTrace ();
        }
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        semaphore.release (1);
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        semaphore1.acquire (1);
        try {
            cyclibarrier.await ();
        } catch (BrokenBarrierException e) {
            e.printStackTrace ();
        }

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        semaphore1.release (1);
    }
}



class BoundedBlockingQueue {

    // 容量
    int capacity;

    // 当前容量
    AtomicInteger currentCapacity = new AtomicInteger (0);

    Node head ;

    Node tail;

    private ReentrantLock takeLock = new ReentrantLock ();
    private Condition notEmpty = takeLock.newCondition();

    private ReentrantLock putLock = new ReentrantLock ();
    private Condition notFull = putLock.newCondition();

    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
        tail = head = new Node (null);
    }

    /**
     * 通知notNull （可以加node）
     */
    private void signalNotFull() {
        putLock.lock ();
        try {
            notFull.signalAll ();
        } finally {
            putLock.unlock ();
        }
    }

    /**
     * 通知notEmpty（可以取node）
     */
    private void signalNotEmpty() {
        takeLock.lock ();
        try {
            notEmpty.signalAll ();
        } finally {
            takeLock.unlock ();
        }
    }

    public void enqueue(int element) throws InterruptedException {
        putLock.lockInterruptibly ();
        int cur;
        try {
            while (currentCapacity.get () == this.capacity) {
                notFull.await ();
            }
            head = head.pre = new Node (element);
            cur = currentCapacity.getAndIncrement ();
            if (cur + 1 < capacity) {
                notFull.signal ();
            }
        } finally {
            putLock.unlock ();
        }

        if (cur == 0) {
            signalNotEmpty();
        }
    }

    public int dequeue() throws InterruptedException {
        takeLock.lockInterruptibly ();
        int cur;

        Integer value = null;
        try {
            while ( currentCapacity.get () == 0) {
                notEmpty.await ();
            }
            Node t = tail;
            Node node = tail.pre;
            t.pre  = t;
            tail = node;
            value = (Integer) node.getValue ();
            node.setValue (null);

            cur = currentCapacity.getAndDecrement ();
            if (cur  > 1) {
                notEmpty.signal ();
            }
        } finally {
            takeLock.unlock ();
        }

        if (cur == this.capacity) {
            signalNotFull ();
        }

        return value;
    }

    public int size() {
        return currentCapacity.get ();
    }


    class Node<E> {
        private  Node pre;


        private E value;


        public Node(E value) {
            this.value = value;
        }

        public Node getPre() {
            return pre;
        }

        public void setPre(Node pre) {
            this.pre = pre;
        }


        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }
    }
}




class FizzBuzz {
    private int n;

    Semaphore semaphore = new Semaphore (1);
    Semaphore semaphore1 = new Semaphore (0);
    Semaphore semaphore2 = new Semaphore (0);
    Semaphore semaphore3 = new Semaphore (0);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 3; i <=n ; i++) {
            if (i % 3 == 0) {
                semaphore1.acquire (1);
                printFizz.run ();
                semaphore.release (1);
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 5; i <=n ; i++) {
            if (i % 5 == 0) {
                semaphore2.acquire (1);
                printBuzz.run ();
                semaphore.release (1);
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 15; i <=n ; i++) {
            if (i % 15 == 0) {
                semaphore3.acquire (1);
                printFizzBuzz.run ();
                semaphore.release (1);
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <=n ; i++) {
            semaphore.acquire (1);
            if (i % 3  == 0 && i % 5 == 0) {
                semaphore3.release (1);
            } else if (i % 3  == 0) {
                semaphore1.release (1);
            } else if (i % 5  == 0) {
                semaphore2.release (1);
            } else  {
                printNumber.accept (i);
                semaphore.release (1);
            }
        }
    }
}

class DiningPhilosophers {

    private ReentrantLock[] locks = {new ReentrantLock (), new ReentrantLock (),new ReentrantLock (),new ReentrantLock (),new ReentrantLock ()};

    public DiningPhilosophers() {

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {


        int leftForkIndex = (philosopher +1) % 5;
        int rightForkIndex = philosopher;

        if (philosopher % 2 == 0) {
            locks[leftForkIndex].lock ();
            locks[rightForkIndex].lock ();
        } else {
            locks[rightForkIndex].lock ();
            locks[leftForkIndex].lock ();
        }

        pickLeftFork.run ();
        pickRightFork.run ();

        eat.run ();

        putLeftFork.run ();
        putRightFork.run ();
        locks[leftForkIndex].unlock ();
        locks[rightForkIndex].unlock ();

    }


    class Solution {
        public int numRescueBoats(int[] people, int limit) {
            Arrays.sort (people);
            int left = 0;
            int right = people.length -1;
            int res = 0;
            while (left < right) {
                if (people[left] + people[right] <= limit) {
                    left ++;
                    right--;
                    res++;
                } else {
                    right--;
                    res++;
                }
            }

            if (left == right) {
                res++;
            }
            return res;
        }
    }
}