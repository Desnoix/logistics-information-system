package com.yjq.user.dao;

import com.yjq.user.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    public User selectById(@Param("id")Long id);

    public User selectByNameAndPw(@Param("username")String username, @Param("password") String password);

    public User findByUsername(@Param("username") String username);

    public Integer addUser(User user);

    /**
     * 校验用户名称是否唯一
     *
     * @param userName 用户名称
     * @return 结果
     */
    public int checkUserNameUnique(String userName);
}