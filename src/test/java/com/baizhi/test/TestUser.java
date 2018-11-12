package com.baizhi.test;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestUser {
    @Autowired
    private UserService userService;
    @Test
    public void queryAll(){
        List<User> allByPageAndRows = userService.queryAllUser(2, 2);
        for (User allByPageAndRow : allByPageAndRows) {
            System.out.println(allByPageAndRow);
        }

    }
}
