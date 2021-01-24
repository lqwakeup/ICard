package com.gradu.servlet;

import com.gradu.entity.User;
import com.gradu.service.IUserService;
import com.gradu.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    ApplicationContext ac = new ClassPathXmlApplicationContext("springConfig.xml");
    IUserService userService = ac.getBean("userService",IUserService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String stuId = req.getParameter("stuId");
        String psd = req.getParameter("psd");

        Cookie cookie = new Cookie("stuId",stuId);
        resp.addCookie(cookie);

        User user = userService.findUserByStuId(stuId);
        if(user!=null){
            if(user.getPassword().equals(psd)){
                JSONResult.JSONReturnWithData("0","登陆成功",resp);
            }else{
                JSONResult.JSONReturnWithData("1","密码错误",resp);
            }
        }else{
            JSONResult.JSONReturnWithData("2","用户不存在",resp);
        }


    }
}
