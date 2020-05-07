package com.spring.boot.study.biz.proxy;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2020-03-12 15:14
 **/
public class MyProxy {

    private static final String rt = "\r";

    public static Object newProxyInstance(MyClassLoader loader, Class<?> interfaces, MyInvocationHandler h) throws IllegalArgumentException{

        if (h == null) {
            throw new NullPointerException ();
        }

        Method[] methods = interfaces.getMethods ();
        StringBuffer proxyClassString =  new StringBuffer ();
        proxyClassString.append ("package ")
                .append (loader.getProxyClassPackage ()).append (";").append (rt)
                .append ("import java.lang.reflect.Method;").append (rt)
                .append ("public class $MyProxy0 implements ").append (interfaces.getName ()).append ("{").append (rt)
                .append ("import java.lang.reflect.Method;").append (rt)
                .append ("import java.lang.reflect.Method;").append (rt)
                .append ("import java.lang.reflect.Method;").append (rt);

        String fileName = loader.getDir () + File.separator + "$MyProxy0.java";
        File myProxyFile = new File(fileName);


        try {
            Class $myProxy0 = loader.findClass ("$MyProxy0");

            Constructor constructor = $myProxy0.getConstructor (MyInvocationHandler.class);
            Object o = constructor.newInstance ();
            return o;
        } catch (Exception e) {
            e.printStackTrace ();
        }

        return null;
    }
}
