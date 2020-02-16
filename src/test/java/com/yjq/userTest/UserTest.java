package com.yjq.userTest;

import com.yjq.user.pojo.User;
import com.yjq.user.service.UserService;
import com.yjq.user.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName UserTest
 * @Author GDMZ_jqyang@outlook.com
 * @Description User测试类
 * @Date 2020/2/12 1:00
 * @Version 1.0
 */
@SpringBootTest
public class UserTest {

    @Test
    void test(){
        UserService userService= new UserServiceImpl();
        User user = new User();
        user.setName("123");
        user.setPassword("123");
        user.setRole("USER");

        String s = userService.addUser(user);
        System.out.println(s);

    }
    @Test
    void testMapper(){
        UserService userService= new UserServiceImpl();

        User s = userService.findUser("123");
        System.out.println(s.toString());

    }

}
