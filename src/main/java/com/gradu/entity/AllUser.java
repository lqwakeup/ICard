package com.gradu.entity;

import java.io.Serializable;
import java.util.List;

public class AllUser implements Serializable {
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "AllUser{" +
                "users=" + users +
                '}';
    }
}
