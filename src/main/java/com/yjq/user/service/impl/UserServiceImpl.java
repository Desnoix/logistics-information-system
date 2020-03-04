package com.yjq.user.service.impl;

import com.yjq.user.dao.UserMapper;
import com.yjq.user.pojo.User;
import com.yjq.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UserDetailsServiceImpl
 * @Author GDMZ_jqyang@outlook.com
 * @Description 用户细节实现类
 * @Date 2020/2/11 23:51
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
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

    @Override
    public User findUser(String username) {
        User user = null;
        try {
            user = userMapper.findByUsername(username);
        } catch (Exception e) {
            return user;
        }
        return user;
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public boolean checkUserNameUnique(String userName)
    {
        User count = userMapper.findByUsername(userName);
        if (!StringUtils.isEmpty(count))
        {
            return false;
        }
        return true;
    }

    @Override
    public List<User> selectUserList(User user) {
        return userMapper.selectUserList(user);
    }
}
