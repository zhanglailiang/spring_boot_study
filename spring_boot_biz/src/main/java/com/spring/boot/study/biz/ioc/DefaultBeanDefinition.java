package com.spring.boot.study.biz.ioc;


/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2020-03-15 17:12
 **/
public class DefaultBeanDefinition implements BeanDefinition {


    private Class<?> clazz;

    private String beanFactoryName;

    private String createBeanMethodName;

    private String staticCreateBeanMethodName;

    private String beanInitMethodName;

    private String beanDestoryMethodName;

    private boolean isSingleton;

    String SCOPE_SINGLETON = "singleton";

    /**
     * Scope identifier for the standard prototype scope: "prototype".
     * Custom scopes can be added via {@code registerScope}.
     */
    String SCOPE_PROTOTYPE = "prototype";

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public String getBeanFactoryName() {
        return beanFactoryName;
    }

    public void setBeanFactoryName(String beanFactoryName) {
        this.beanFactoryName = beanFactoryName;
    }

    public String getCreateBeanMethodName() {
        return createBeanMethodName;
    }

    public void setCreateBeanMethodName(String createBeanMethodName) {
        this.createBeanMethodName = createBeanMethodName;
    }

    public String getStaticCreateBeanMethodName() {
        return staticCreateBeanMethodName;
    }

    public void setStaticCreateBeanMethodName(String staticCreateBeanMethodName) {
        this.staticCreateBeanMethodName = staticCreateBeanMethodName;
    }

    public String getBeanInitMethodName() {
        return beanInitMethodName;
    }

    public void setBeanInitMethodName(String beanInitMethodName) {
        this.beanInitMethodName = beanInitMethodName;
    }

    public String getBeanDestoryMethodName() {
        return beanDestoryMethodName;
    }

    public void setBeanDestoryMethodName(String beanDestoryMethodName) {
        this.beanDestoryMethodName = beanDestoryMethodName;
    }

    public boolean isSingleton() {
        return isSingleton;
    }

    public void setSingleton(boolean singleton) {
        isSingleton = singleton;
    }
}

