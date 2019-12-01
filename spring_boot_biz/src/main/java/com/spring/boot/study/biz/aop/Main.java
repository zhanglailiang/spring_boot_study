package com.spring.boot.study.biz.aop;

import com.spring.boot.study.biz.aop.impl.HelloServicImpl;
import com.spring.boot.study.biz.aop.impl.MyInterceptor;
import com.spring.boot.study.biz.aop.proxy.ProxyBean;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import java.util.List;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-03-31 18:49
 **/
public class Main {

    public static void main(String[] args) {

        ScriptEngineManager scriptEngineManager = new ScriptEngineManager ();
        List<ScriptEngineFactory> engineFactories = scriptEngineManager.getEngineFactories ();

        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName ("test");
//        scriptEngine.eval ("1=2");

        HelloService helloService =  new HelloServicImpl ();
        HelloService proxy = (HelloService) ProxyBean.getProxyBean (helloService, new MyInterceptor ());

        proxy.sayHello ("zhanglailiang");
    }
}
