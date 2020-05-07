package com.spring.boot.study.biz.designmode;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2020-05-06 17:42
 **/
public class CommonFactory {

    public static void main(String[] args) {
        //创建具体的工厂
        FactoryA factoryA = new FactoryA();
        //生产相对应的产品
        factoryA.getProduct().intro();
        FactoryB factoryB = new FactoryB();
        factoryB.getProduct().intro();
    }

}


abstract class Product {
    //产品介绍
    abstract void intro();
}

/**
 * @ ProductA.java
 * 具体产品A
 */
class ProductA extends Product{
    @Override
    void intro() {
        System.out.println("饮料A");
    }
}

/**
 * @ ProductB.java
 * 具体产品B
 */
class ProductB extends Product{
    @Override
    void intro() {
        System.out.println("饮料B");
    }
}

/**
 *  @ Factory.java
 *    抽象工厂
 */
abstract class Factory {
    //生产产品
    abstract Product getProduct();
}

/**
 * @ FactoryA.java
 * 具体工厂A
 * 负责具体的产品A生产
 */
 class FactoryA extends Factory{
    @Override
    Product getProduct() {
        return new ProductA();
    }
}

/**
 * @ FactoryB.java
 * @具体工厂B
 * 负责具体的产品B生产
 */
 class FactoryB extends Factory{
    @Override
    Product getProduct() {
        return new ProductB();
    }
}