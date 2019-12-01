package com.spring.boot.study.biz.es;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-09-23 18:39
 **/
public interface CommodityService {

    long count();

    Commodity save(Commodity commodity);

    void delete(Commodity commodity);

    Iterable<Commodity> getAll();

    List<Commodity> getByName(String name);

    Page<Commodity> pageQuery(Integer pageNo, Integer pageSize, String kw);

}