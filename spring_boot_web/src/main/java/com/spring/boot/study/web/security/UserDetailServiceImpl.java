package com.spring.boot.study.web.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-03-31 15:03
 **/
@Component
public class UserDetailServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        UserDetails userDetails = new UserDetails () {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                GrantedAuthority authority  = (GrantedAuthority) () -> "ROLE_USER";
                return Arrays.asList (authority);
            }

            @Override
            public String getPassword() {
                return "a1c819404aac821b9020da3de52e9093c07ad06bdbb25ef526663684f0701f02e85538d6236b5b6d";
            }

            @Override
            public String getUsername() {
                return "zhanglailiang";
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
        return userDetails;
    }

}
