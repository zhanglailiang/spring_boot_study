package com.spring.boot.study.biz.aop;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-03-31 18:33
 **/
public class Invocation {

    private Object[] params;

    private Method method;

    private Object target;

    public Invocation(Object target, Method method,  Object[] params) {
        this.params = params;
        this.method = method;
        this.target = target;
    }

    public  Object process() throws InvocationTargetException, IllegalArgumentException, IllegalAccessException {
        return method.invoke (target, params);
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}
