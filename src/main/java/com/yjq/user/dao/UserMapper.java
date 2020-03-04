package com.yjq.user.dao;

import com.yjq.user.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    public User selectById(@Param("id")Long id);

    public User selectByNameAndPw(@Param("username")String username, @Param("password") String password);

    public User findByUsername(@Param("username") String username);

    public int addUser(User user);

    public List<User> selectUserList(User user);
}