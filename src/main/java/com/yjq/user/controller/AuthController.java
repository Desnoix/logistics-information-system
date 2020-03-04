package com.yjq.user.controller;

import com.yjq.user.pojo.User;
import com.yjq.user.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName AuthController
 * @Author GDMZ_jqyang@outlook.com
 * @Description 登陆权限控制器
 * @Date 2020/2/16 16:08
 * @Version 1.0
 */
@RestController
@RequestMapping("/auth")
@Api(tags = "用户注册接口")
public class AuthController {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserService userService;


    @PostMapping("/register")
    public String registerUser(@RequestBody Map<String,String> registerUser){
        User user = new User();
        user.setName(registerUser.get("username"));
        // 记得注册的时候把密码加密一下
        user.setPassword(bCryptPasswordEncoder.encode(registerUser.get("password")));
        user.setRole("ROLE_USER");
        int save = userService.addUser(user);
        return "成功";
    }


}
