package com.yjq.user.service;

import com.yjq.user.pojo.User;

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
    public String addUser(User user);

    /**
     * 校验用户名称是否唯一
     *
     * @param userName 用户名称
     * @return 结果
     */
    public boolean checkUserNameUnique(String userName);

}
