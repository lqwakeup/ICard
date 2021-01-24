package com.gradu.dao;

import com.gradu.entity.Account;

import java.util.List;

public interface IAccountDao {
    //通过学号找到账单信息
    List<Account> findAccountsByStuId(String stuId);

    //插入一条记录
    void insertAccount(Account account);
}
