package com.spring.boot.study.biz.stream;

import javassist.*;

import java.io.IOException;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-09-12 17:17
 **/
public class JavassistTest {

    public static void main(String[] args) throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, IOException {
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("com.spring.boot.study.biz.stream.Test");
        CtMethod m = cc.getDeclaredMethod("process");
        m.insertBefore("{ System.out.println(\"start\"); }");
        m.insertAfter("{ System.out.println(\"end\"); }");
        Class c = cc.toClass();
        cc.writeFile("D:\\test");
        Test h = (Test)c.newInstance();
//        h.process();
    }


}
