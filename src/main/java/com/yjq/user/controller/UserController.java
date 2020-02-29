package com.yjq.user.controller;

import com.yjq.common.Controller.BaseController;
import com.yjq.common.ResultVO;
import com.yjq.common.utils.JwtTokenUtils;
import com.yjq.user.pojo.User;
import com.yjq.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName UserController
 * @Author GDMZ_jqyang@outlook.com
 * @Description 用户控制器
 * @Date 2020/1/21 19:39
 * @Version 1.0
 */
@Api(tags = "用户通用接口")
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    @RequestMapping("/test")
    public Object test(){
        User user = new User();
        user.setName("456");
        user.setPassword("789");
        user.setRole("USER");
        return userService.addUser(user);
    }

    @GetMapping
    @ApiOperation("获取用户信息")
    public Map<String, Object> getUserInfo(@RequestParam String token){
        String s = StringUtils.trimAllWhitespace(token);
        String username = JwtTokenUtils.getUsername(s);
        User user = userService.findUser(username);
        return ResultVO.success(user);
    }

}
