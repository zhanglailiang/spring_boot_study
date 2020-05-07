package com.spring.boot.study.biz.proxy;

import org.apache.lucene.store.FileSwitchDirectory;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2020-03-12 14:50
 **/
public class MyClassLoader extends ClassLoader{

    private File dir;

    private String proxyClassPackage;

    public File getDir() {
        return dir;
    }

    public String getProxyClassPackage() {
        return proxyClassPackage;
    }

    public MyClassLoader(File dir, String proxyClassPackage) {
        this.dir = dir;
        this.proxyClassPackage = proxyClassPackage;
    }

    // 定义自己classLoad 就是为了自己能够定位到问题
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if (dir  != null) {
            File classFile = new File (dir, name + ".class");
            if (classFile.exists ()) {
                try {
                    byte[] classBytes = FileCopyUtils.copyToByteArray (classFile);
                    return defineClass(proxyClassPackage + "." +name, classBytes, 0, classBytes.length);
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }
        }
        return super.findClass (name);
    }


}
