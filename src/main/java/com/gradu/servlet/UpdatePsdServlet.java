package com.gradu.servlet;

import com.alibaba.fastjson.JSON;
import com.gradu.entity.User;
import com.gradu.service.IUserService;
import com.gradu.utils.JSONPsd;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updatePsd")
public class UpdatePsdServlet extends HttpServlet {
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
        String stuId = null;
        String psd = req.getParameter("psd");
        String oldPsd = req.getParameter("oldPsd");
        String confirmPsd = req.getParameter("confirmPsd");
//        System.out.println(psd);

        Cookie[] cookies = req.getCookies();
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("stuId")){
                stuId = cookie.getValue();
                System.out.println(stuId);
            }
        }

        User user = userService.findUserByStuId(stuId);
        String oldPsd1 = user.getPassword();

        if(oldPsd.equals(oldPsd1)){
            if(psd.equals(confirmPsd)){
                user.setPassword(psd);
                userService.updateUser(user);
                JSONPsd.JSONPsdResult(oldPsd,psd,0,"密码修改成功",resp);
            }else {
                JSONPsd.JSONPsdResult(oldPsd,psd,1,"两次输入密码不一致",resp);
            }
        }else{
            JSONPsd.JSONPsdResult(oldPsd,psd,2,"初始密码输入错误",resp);
        }
    }
}
