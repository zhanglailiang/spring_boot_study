package com.spring.boot.study.biz.es;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-09-23 18:38
 **/
@Repository
public interface CommodityRepository extends ElasticsearchRepository<Commodity, String> {

}
