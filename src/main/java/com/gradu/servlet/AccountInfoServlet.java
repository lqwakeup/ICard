package com.gradu.servlet;

import com.alibaba.fastjson.JSON;
import com.gradu.entity.Account;
import com.gradu.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/accountInfo")
public class AccountInfoServlet extends HttpServlet {
    ApplicationContext ac = new ClassPathXmlApplicationContext("springConfig.xml");
    IAccountService accountService = ac.getBean("accountService", IAccountService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String stuId = null;
        Cookie[] cookies = req.getCookies();

        for(Cookie cookie:cookies){
            if(cookie.getName().equals("stuId")){
                stuId = cookie.getValue();
            }
        }

        List<Account> accounts = accountService.findAccountsByStuId(stuId);
        String accountsJson = JSON.toJSONString(accounts);

        resp.getWriter().print(accountsJson);

        
    }
}
