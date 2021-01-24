package com.gradu.entity;

import java.io.Serializable;

public class Card implements Serializable {
    private Integer id;
    private String holderName;
    private String stuId;
    private String cardId;
    private String password;
    private Double balance;
    private Integer status;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", holderName='" + holderName + '\'' +
                ", stuId='" + stuId + '\'' +
                ", cardId='" + cardId + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", status=" + status +
                '}';
    }
}
