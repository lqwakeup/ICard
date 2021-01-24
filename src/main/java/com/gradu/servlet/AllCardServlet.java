package com.gradu.servlet;

import com.gradu.entity.Card;
import com.gradu.service.ICardService;
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

@WebServlet("/allCard")
public class AllCardServlet extends HttpServlet {
    ApplicationContext ac = new ClassPathXmlApplicationContext("springConfig.xml");
    ICardService cardService = ac.getBean("cardService",ICardService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("html/text;charset=utf-8");
        req.setCharacterEncoding("utf-8");

        List<Card> cards = cardService.findAllCards();
        JSONResult.JSONReturnAllCard(cards,resp);
    }
}
