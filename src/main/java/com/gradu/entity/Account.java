package com.gradu.entity;

import java.io.Serializable;
import java.util.Date;

public class Account implements Serializable {
    private int id;
    private String stuId;
    private String currentTime;
    private Double income;
    private Double expand;
    private String moneyDesc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Double getExpand() {
        return expand;
    }

    public void setExpand(Double expand) {
        this.expand = expand;
    }

    public String getMoneyDesc() {
        return moneyDesc;
    }

    public void setMoneyDesc(String moneyDesc) {
        this.moneyDesc = moneyDesc;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", stuId='" + stuId + '\'' +
                ", currentTime=" + currentTime +
                ", income=" + income +
                ", expand=" + expand +
                ", moneyDesc='" + moneyDesc + '\'' +
                '}';
    }
}
