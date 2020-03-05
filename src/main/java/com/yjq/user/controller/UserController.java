package com.yjq.user.controller;

import com.yjq.common.Controller.BaseController;
import com.yjq.common.ResultVO;
import com.yjq.common.utils.JwtTokenUtils;
import com.yjq.user.pojo.User;
import com.yjq.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
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
@RequestMapping("/users")
public class UserController extends BaseController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserService userService;

    @ApiOperation("添加用户")
    @PostMapping
    public Map<String,Object> addUser(@RequestBody @Validated User user){
        if(userService.checkUserNameUnique(user.getName())){
            user.setCreateTime(new Date());
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setDeleted(0);
            int i = userService.addUser(user);
            return toResult(i);
        }else {
            return ResultVO.failure(102,"用户已存在");
        }

    }

    @GetMapping("/{userId}")
    @ApiOperation("根据id获取用户信息")
    public Map<String,Object> getUserById(@PathVariable("userId") Integer id){
        User user = userService.selectUserById(id);
        return ResultVO.success(user);
    }

    @PutMapping
    @ApiOperation("更新用户信息")
    public Map<String,Object> updateUser(@RequestBody @Validated User user){
        int i = userService.updateUser(user);
        return toResult(i);
    }

    @PutMapping("/updatePwd")
    @ApiOperation("重置用户密码")
    public Map<String,Object> updatePwd(@RequestBody @Validated User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        int i = userService.updateUser(user);
        return toResult(i);
    }

    @DeleteMapping("/{userId}")
    @ApiOperation("删除用户")
    public  Map<String,Object> deleteUser(@PathVariable("userId") Integer[] userId){
        for (int i = 0;i<userId.length;i++) {
            User user = userService.selectUserById(userId[i]);
            user.setDeleted(1);
            userService.updateUser(user);
        }
        return ResultVO.success();
    }

    @PostMapping("/logout")
    @ApiOperation("退出登陆")
    public Map<String,Object> logout(){
        System.out.println("=============用户退出成功=====================");
       return ResultVO.success();
    }

    @GetMapping("/getInfo")
    @ApiOperation("根据token获取用户信息")
    public Map<String, Object> getUserInfo(@RequestParam String token){
        String s = StringUtils.trimAllWhitespace(token);
        String username = JwtTokenUtils.getUsername(s);
        User user = userService.findUser(username);
        return ResultVO.success(user);
    }

    @GetMapping("/list")
    @ApiOperation("获取所有用户信息")
    public Map<String, Object> list(User user)
    {
        startPage();//分页
        List<User> list = userService.selectUserList(user);
        return ResultVO.success(list);
    }


}
