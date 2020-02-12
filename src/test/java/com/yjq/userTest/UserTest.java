package com.yjq.userTest;

import com.yjq.user.service.UserDetailsService;
import com.yjq.user.service.impl.UserDetailsServiceImpl;
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
        UserDetailsService userDetailsService = new UserDetailsServiceImpl();
        boolean result = userDetailsService.findUser("123", "123");
        System.out.println(result);
    }

}
