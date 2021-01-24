package com.gradu.service.impl;

import com.gradu.dao.IAccountDao;
import com.gradu.entity.Account;
import com.gradu.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    @Override
    public List<Account> findAccountsByStuId(String stuId) {
        return accountDao.findAccountsByStuId(stuId);
    }

    @Override
    public void insertAccount(Account account) {
        accountDao.insertAccount(account);

    }
}
