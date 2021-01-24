package com.gradu.dao;

import com.gradu.entity.User;

import java.util.List;

public interface IUserDao {
    //查找用户
    User findUserByStuId(String stuId);

    //寻找所有的学生
    List<User> findUsers();

    //修改密码
    void updateUser(User user);

    //插入一条数据
    void insertUser(User user);

    //删除一条记录
    void deleteUser(String stuId);

    //删除多条记录
    void deleteMUser(List<String> stuIds);

    //编辑数据的多项
    void updateMUser(User user,String oldstuId);

}
