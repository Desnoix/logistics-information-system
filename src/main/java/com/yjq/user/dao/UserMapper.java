package com.yjq.user.dao;

import com.yjq.user.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    User selectById(@Param("id")Long id);

    User selectByNameAndPw(@Param("username")String username, @Param("password") String password);

    User findByUsername(@Param("username") String username);

    Integer addUser(User user);
}