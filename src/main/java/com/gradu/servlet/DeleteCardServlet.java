package com.gradu.servlet;

import com.gradu.service.ICardService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteCard")
public class DeleteCardServlet extends HttpServlet {
    ApplicationContext ac = new ClassPathXmlApplicationContext("springConfig.xml");
    ICardService cardService = ac.getBean("cardService",ICardService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String stuId = req.getParameter("stuId");
        cardService.deleteCard(stuId);
    }
}
