package com.spring.boot.study.biz.es;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @program: spring_boot_study
 * @description: 定义一个实体类
 * @author: zhanglailiang
 * @create: 2019-09-23 18:26
 **/
@Data
@Document(indexName = "commodity1")
public class Commodity implements Serializable {

    @Id
    private String skuId;

    private String name;

    private String category;

    private Integer price;

    private String brand;

    private Integer stock;

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
