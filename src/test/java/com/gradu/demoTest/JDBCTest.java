package com.gradu.demoTest;

import com.gradu.entity.User;
import com.gradu.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class JDBCTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("springConfig.xml");
        IUserService userService = ac.getBean("userService",IUserService.class);

        List<User> users =  userService.findUsers();
        for(User user:users){
            System.out.println(user);
        }
    }

}
