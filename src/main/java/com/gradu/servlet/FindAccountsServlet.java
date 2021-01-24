package com.gradu.servlet;

import com.alibaba.fastjson.JSON;
import com.gradu.entity.Account;
import com.gradu.service.IAccountService;
import com.gradu.utils.JSONResult;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findAccounts")
public class FindAccountsServlet extends HttpServlet {
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

        String stuId = req.getParameter("stuId");

        List<Account> accounts = accountService.findAccountsByStuId(stuId);
        System.out.println(accounts);
        String accountsJson = JSON.toJSONString(accounts);

        resp.getWriter().print(accountsJson);
    }
}
