package com.gradu.service;

import com.gradu.entity.User;

import java.util.List;

public interface IUserService {
    //查找用户
    User findUserByStuId(String stuId);
    //测试数据库
    List<User> findUsers();

    void updateUser(User user);

    void insertUser(User user);

    void deleteUser(String stuId);

    void deleteMUser(List<String> stuIds);

    void updateMUser(User user,String oldstuId);

}
