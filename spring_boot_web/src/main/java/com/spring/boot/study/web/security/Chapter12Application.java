package com.spring.boot.study.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-03-31 14:45
 **/
@Component
public class Chapter12Application extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Value ("${system.user.password.secret}")
    private String secret = null;

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // 基础版本
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder ();
//        auth.inMemoryAuthentication ()
//                .passwordEncoder (passwordEncoder)
//                .withUser ("zhanglailiang")
//                .password ("$2a$10$AHI/7iAscTdEDNM1cy/aYOXlRDUwvNtzwv7VxNUo8/NFrr8RALfSi")
//                .roles ("USER", "ADMIN")
//                .and ()
//                .withUser ("myuser")
//                .password ("$2a$10$33dGdtAJ1FkGCoKf9OPz8urM/4kWcnwBXbUmK5X0H0OFNA79fPFni")
//                .roles ("USER");

        // 稍微基础版本
//        InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> configurer = auth.inMemoryAuthentication ()
//                .passwordEncoder (passwordEncoder);
//        configurer.withUser ("zhanglailiang")
//                .password ("$2a$10$AHI/7iAscTdEDNM1cy/aYOXlRDUwvNtzwv7VxNUo8/NFrr8RALfSi")
//                .authorities ("USER", "ADMIN");
//        configurer.withUser ("myuser")
//                .password ("$2a$10$33dGdtAJ1FkGCoKf9OPz8urM/4kWcnwBXbUmK5X0H0OFNA79fPFni")
//                .authorities ("USER");

        // 基于数据库办版本


        // 基于服务版本
        passwordEncoder = new Pbkdf2PasswordEncoder (secret);
        auth.userDetailsService (userDetailsService)
            .passwordEncoder (passwordEncoder);
    }


    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests ()
//                .antMatchers ("/user/**").hasAnyRole ("USER", "ADMIN")
//                .antMatchers ("/admin/**").hasAuthority ("ROLE_ADMIN")
//
//                // 使用登录页面 不填则为默认
//                .and ().formLogin ()
//
//                // 启动http基础验证
//                .and ().httpBasic ();
        http.requiresChannel () .antMatchers ("/admin/**").requiresSecure ()
                .and()
                .requiresChannel ().antMatchers ("/user/**")
                .requiresInsecure ()
                .and ()
                .authorizeRequests ()
                .antMatchers ("/user/**").hasAnyRole ("USER", "ADMIN")
                .antMatchers ("/admin/**").hasAuthority ("ROLE_ADMIN")
                // 使用登录页面 不填则为默认
                .and ().formLogin ()
                // 启动http基础验证
                .and ().httpBasic ();

    }


    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder ("123456");
        String zhang = passwordEncoder.encode ("zhang");
        System.out.println (zhang);
    }
}
