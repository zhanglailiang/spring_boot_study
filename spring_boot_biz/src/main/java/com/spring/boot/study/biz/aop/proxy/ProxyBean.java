package com.spring.boot.study.biz.aop.proxy;

import com.spring.boot.study.biz.aop.Interceptor;
import com.spring.boot.study.biz.aop.Invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-03-31 18:38
 **/
public class ProxyBean implements InvocationHandler {

    private Object tatget;

    private Interceptor interceptor;

    /**
     * @param target 被代理对象
     * @param interceptor 拦截器
     * @return
     */
    public static Object getProxyBean(Object target, Interceptor interceptor) {
        ProxyBean proxyBean = new ProxyBean ();
        proxyBean.tatget = target;
        proxyBean.interceptor = interceptor;
        Class<?> aClass = target.getClass ();
        Class<?>[] interfaces = aClass.getInterfaces ();
        Object proxy = Proxy.newProxyInstance (aClass.getClassLoader (),
                interfaces, proxyBean);

        return proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        boolean exceptionFlag = false;
        Invocation invocation = new Invocation (tatget, method, args);
        Object retObj = null;
        if(this.interceptor.before ()) {
            retObj = this.interceptor.around (invocation);
        } else {
            retObj = method.invoke (tatget, args);
        }

        return retObj;
    }
}
