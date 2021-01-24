package com.gradu.servlet;

import com.gradu.entity.User;
import com.gradu.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {
    ApplicationContext ac = new ClassPathXmlApplicationContext("springConfig.xml");
    IUserService userService = ac.getBean("userService",IUserService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;utf-8");

        String stuId = req.getParameter("stuId");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String cardId = req.getParameter("cardId");
        String bankCard = req.getParameter("bankCard");
        String desc = req.getParameter("desc");
        User user = new User();
        user.setStuId(stuId);
        user.setName(name);
        user.setSex(sex);
        user.setCardId(cardId);
        user.setBankCard(bankCard);
        user.setDescs(desc);
//        System.out.println(user);
        userService.insertUser(user);
    }
}
