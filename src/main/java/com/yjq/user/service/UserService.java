package com.yjq.user.service;

import com.yjq.user.pojo.User;

import java.util.List;

public interface UserService {
    /**
     *
     * @param username
     * @param password
     * @return
     */
    public boolean findUser(String username,String password);

    /**
     *
     * @param username
     * @return
     */
    public User findUser(String username);

    /**
     *
     * @param user
     * @return
     */
    public int addUser(User user);

    /**
     * 校验用户名称是否唯一
     *
     * @param userName 用户名称
     * @return 结果
     */
    public boolean checkUserNameUnique(String userName);

    /**
     * 获取所有用户信息
     * @param user
     * @return
     */
    public List<User> selectUserList(User user);


    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    public User selectUserById(Integer id);

    /***
     * 更新用户信息
     * @param user
     * @return
     */
    public int updateUser(User user);
}
