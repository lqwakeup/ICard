package com.gradu.dao.impl;

import com.gradu.dao.IAccountDao;
import com.gradu.entity.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private QueryRunner runner;

    @Override
    public List<Account> findAccountsByStuId(String stuId) {
        try{
            List<Account> accounts = runner.query("select * from account where stuId = ?",new BeanListHandler<Account>(Account.class),stuId);
            if(accounts.size()==0){
                return null;
            }
            return accounts;
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void insertAccount(Account account) {
        try{
            runner.update("insert into account(stuId,currentTime,income,expand,moneyDesc)values(?,?,?,?,?)",account.getStuId(),
                     account.getCurrentTime(),account.getIncome(),account.getExpand(),account.getMoneyDesc());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
