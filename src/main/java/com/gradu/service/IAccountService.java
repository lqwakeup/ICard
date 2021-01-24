package com.gradu.service;

import com.gradu.entity.Account;

import java.util.List;

public interface IAccountService {

    List<Account> findAccountsByStuId(String stuId);

    void insertAccount(Account account);
}
