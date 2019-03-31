package com.spring.boot.study.web.webscoket;

import com.spring.boot.study.api.pojo.User;
import com.spring.boot.study.biz.webflux.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-03-31 17:02
 **/
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/getuser")
    public Mono<User> getUser() {
        return userService.getUser (1L);
    }

    @GetMapping("/user/getusers")
    public Flux<User> getUsers() {
        return userService.getUsers (1L);
    }

}
