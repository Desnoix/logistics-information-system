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
}
