package com.yjq.user.service;

public interface UserDetailsService {
    /**
     *
     * @param username
     * @param password
     * @return
     */
    public boolean findUser(String username,String password);
}
