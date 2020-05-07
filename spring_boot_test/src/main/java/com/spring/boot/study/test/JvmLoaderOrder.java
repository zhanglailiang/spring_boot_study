package com.spring.boot.study.test;

/**
 * @program: spring_boot_study
 * @description: 类的加载顺序
 * @author: zhanglailiang
 * @create: 2020-04-22 15:50
 **/
public class JvmLoaderOrder {

    int a = 10;
    static int b = 11;

    static JvmLoaderOrder jvmLoaderOrder = new JvmLoaderOrder ();

    static {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    JvmLoaderOrder() {
        System.out.println("3");
        System.out.println("a = " + a +", b = " + b);
    }

    public static void staticFunction(){
        System.out.println("4");
    }

    public static void main(String[] args) {
        staticFunction();
    }

}
