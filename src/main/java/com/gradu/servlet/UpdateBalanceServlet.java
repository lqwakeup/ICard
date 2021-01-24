package com.gradu.servlet;

import com.gradu.entity.Account;
import com.gradu.entity.Card;
import com.gradu.service.IAccountService;
import com.gradu.service.ICardService;
import com.gradu.utils.JSONResult;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

@WebServlet("/updateBalance")
public class UpdateBalanceServlet extends HttpServlet {
    ApplicationContext ac = new ClassPathXmlApplicationContext("springConfig.xml");
    ICardService cardService = ac.getBean("cardService",ICardService.class);
    IAccountService accountService = ac.getBean("accountService",IAccountService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");

        String balance = req.getParameter("balance");
        Double ban = Double.parseDouble(balance);

        String stuId = null;
        Cookie[] cookies = req.getCookies();
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("stuId")){
                stuId = cookie.getValue();
            }
        }

        Card card = cardService.findCargByStuId(stuId);

        if(card.getStatus() == 0){
            card.setBalance(card.getBalance()+ban);
            cardService.updateBalance(card);
            long now=System.currentTimeMillis();//获取当前系统时间
            java.sql.Date d=new Date(now);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String str = format.format(d);
            Account account = new Account();
            account.setStuId(stuId);
            account.setIncome(ban);
            account.setExpand(0d);
            account.setCurrentTime(str);
            account.setMoneyDesc("充值");
            accountService.insertAccount(account);
            JSONResult.JSONReturnWithData("0","充值成功",resp);

        }else{
            JSONResult.JSONReturnWithData("1","校园卡已经停用，不能进行此操作",resp);
        }



    }
}
