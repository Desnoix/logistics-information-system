package com.yjq.user.controller;

import com.yjq.user.pojo.User;
import com.yjq.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName UserController
 * @Author GDMZ_jqyang@outlook.com
 * @Description 用户控制器
 * @Date 2020/1/21 19:39
 * @Version 1.0
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping("/test")
    @ResponseBody
    public Object test(){

        User user = new User();
        user.setName("456");
        user.setPassword("789");
        user.setRole("USER");
        return userService.addUser(user);
    }
}
