package com.gradu.servlet;

import com.gradu.entity.Admin;
import com.gradu.service.IAdminService;
import com.gradu.utils.JSONResult;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {

    ApplicationContext ac = new ClassPathXmlApplicationContext("springConfig.xml");
    IAdminService adminService = ac.getBean("adminService",IAdminService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String aid = req.getParameter("aid");
        String psd = req.getParameter("psd");

        Admin admin =  adminService.findAdminByAid(aid);

        if(admin != null){
            if(admin.getPassword().equals(psd)){
                JSONResult.JSONReturnWithData("0","登陆成功",resp);
            }else {
                JSONResult.JSONReturnWithData("1","密码错误",resp);
            }
        }else{
            JSONResult.JSONReturnWithData("2","用户不存在",resp);
        }

    }
}
