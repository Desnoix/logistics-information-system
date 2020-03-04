package com.yjq.userTest;

import com.yjq.user.dao.UserMapper;
import com.yjq.user.pojo.User;
import com.yjq.user.service.UserService;
import com.yjq.user.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

/**
 * @ClassName UserTest
 * @Author GDMZ_jqyang@outlook.com
 * @Description User测试类
 * @Date 2020/2/12 1:00
 * @Version 1.0
 */
@SpringBootTest
public class UserTest {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService userService;

    @Test
    void test(){
        User user = new User();
        user.setAccount("213");
        user.setEmail("saa");
        user.setDeptId(2);
        //user.setPhoneNumber("32");
       // user.setName("123");
        user.setPassword("123");
       // user.setRole("ROLE_USER");
        user.setCreateTime(new Date());

        //int i = userMapper.addUser(user);
        int s = userService.addUser(user);
        System.out.println(s);

    }
    @Test
    void testMapper(){
        UserService userService= new UserServiceImpl();

        User s = userService.findUser("123");
        System.out.println(s.toString());

    }
    @Test
    void testMapper1(){
        User user = new User();
        user.setName("admin");

        List<User> users = userMapper.selectUserList(user);

        System.out.println(users.toString());

    }


}
