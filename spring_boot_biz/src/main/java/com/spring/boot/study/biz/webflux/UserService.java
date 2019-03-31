package com.spring.boot.study.biz.webflux;

import com.spring.boot.study.api.pojo.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<User> getUser(Long id);

    Mono<User> insertUser(Long id);

    Mono<Void> deleteUser(Long id);

    Flux<User> getUsers(Long id);
}
