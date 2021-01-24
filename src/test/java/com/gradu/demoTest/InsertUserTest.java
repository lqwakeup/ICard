package com.gradu.demoTest;

import com.gradu.entity.User;
import com.gradu.service.IAccountService;
import com.gradu.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InsertUserTest {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("springConfig.xml");
        IUserService userService = ac.getBean("userService",IUserService.class);

        User user = new User();
        user.setStuId("2016003");
        user.setName("小乔");

        userService.insertUser(user);

    }
}
