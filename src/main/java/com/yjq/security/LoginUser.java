package com.yjq.security;

/**
 * @ClassName LoginUser
 * @Author GDMZ_jqyang@outlook.com
 * @Description 登陆的用户信息
 * @Date 2020/2/15 19:54
 * @Version 1.0
 */
public class LoginUser {
    private String username;
    private String password;
    private Integer rememberMe;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Integer rememberMe) {
        this.rememberMe = rememberMe;
    }
}
