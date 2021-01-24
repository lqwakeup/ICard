package com.gradu.servlet;

import com.alibaba.fastjson.JSON;
import com.gradu.entity.Card;
import com.gradu.service.ICardService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cardInfo")
public class CardInfoServlet extends HttpServlet {

    ApplicationContext ac = new ClassPathXmlApplicationContext("springConfig.xml");
    ICardService cardService = ac.getBean("cardService",ICardService.class);

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

        Card card = cardService.findCargByStuId(stuId);
        String cardStr = JSON.toJSONString(card);

        resp.getWriter().print(cardStr);
    }
}
