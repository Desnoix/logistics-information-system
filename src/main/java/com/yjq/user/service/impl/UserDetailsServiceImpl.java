package com.yjq.user.service.impl;

import com.yjq.user.dao.UserMapper;
import com.yjq.user.pojo.User;
import com.yjq.user.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName UserDetailsServiceImpl
 * @Author GDMZ_jqyang@outlook.com
 * @Description 用户细节实现类
 * @Date 2020/2/11 23:51
 * @Version 1.0
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean findUser(String username, String password) {
        User user = null;
        try {
            user = userMapper.selectByNameAndPw(username, password);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
