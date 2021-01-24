package com.gradu.entity;

import java.io.Serializable;
import java.util.List;

public class AllAccount implements Serializable {
    private List<Account> accounts;

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
