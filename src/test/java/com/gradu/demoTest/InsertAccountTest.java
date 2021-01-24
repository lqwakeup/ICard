package com.gradu.demoTest;

import com.gradu.entity.Account;
import com.gradu.service.IAccountService;
import com.gradu.service.ICardService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

public class InsertAccountTest {


    public static void main(String[] args) throws ParseException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("springConfig.xml");
        IAccountService accountService = ac.getBean("accountService",IAccountService.class);
        System.out.println(accountService);

        long now=System.currentTimeMillis();//获取当前系统时间
        Date d=new Date(now);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(d);

        Account account = new Account();
        account.setStuId("2016001");
        account.setIncome(12d);
        account.setExpand(0d);
        account.setCurrentTime(str);
        account.setMoneyDesc("充值");
        System.out.println(account);
        accountService.insertAccount(account);

//        List<Account> accounts = accountService.findAccountsByStuId("2016001");
//        for(Account account:accounts){
//            System.out.println(account);
//        }
    }
}
