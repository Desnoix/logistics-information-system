package com.yjq.user.controller;

import com.yjq.user.dao.UserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @ClassName UserController
 * @Author GDMZ_jqyang@outlook.com
 * @Description 用户控制器
 * @Date 2020/1/21 19:39
 * @Version 1.0
 */
@Controller
public class UserController {

    @Resource
    UserMapper userMapper;


    @RequestMapping("/test")
    @ResponseBody
    public Object test(){

        return userMapper.selectById(1L);
    }
}
