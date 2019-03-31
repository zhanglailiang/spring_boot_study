package com.spring.boot.study.biz.webflux.impl;

import com.spring.boot.study.api.pojo.User;
import com.spring.boot.study.biz.webflux.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-03-31 16:59
 **/
@Service
public class UserServiceImpl implements UserService {
    @Override
    public Mono<User> getUser(Long id) {
        User user =  new User ();
        user.setAge (1);
        user.setName ("111");
        return Mono.just (user);
    }

    @Override
    public Mono<User> insertUser(Long id) {
        return null;
    }

    @Override
    public Mono<Void> deleteUser(Long id) {
        return null;
    }

    @Override
    public Flux<User> getUsers(Long id) {
        User user =  new User ();
        user.setAge (1);
        user.setName ("111");

        User user1 =  new User ();
        user.setAge (2);
        user.setName ("111");

        return  Flux.just (user, user1);
    }
}
