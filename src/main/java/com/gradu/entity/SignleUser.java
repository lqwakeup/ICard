package com.gradu.entity;

import java.io.Serializable;

public class SignleUser implements Serializable {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
