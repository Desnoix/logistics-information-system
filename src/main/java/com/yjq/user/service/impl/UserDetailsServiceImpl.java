package com.yjq.user.service.impl;

import com.yjq.user.pojo.JwtUser;
import com.yjq.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserDetailsServiceImpl
 * @Author GDMZ_jqyang@outlook.com
 * @Description 使用springSecurity需要实现UserDetailsService接口供权限框架调用
 * @Date 2020/2/13 22:45
 * @Version 1.0
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserServiceImpl userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.findUser(s);
        return new JwtUser(user);
    }
}
