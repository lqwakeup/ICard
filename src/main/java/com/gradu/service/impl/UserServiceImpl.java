package com.gradu.service.impl;

import com.gradu.dao.IUserDao;
import com.gradu.entity.User;
import com.gradu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;
    public User findUserByStuId(String stuId) {
        return  userDao.findUserByStuId(stuId);
    }

    @Override
    public List<User> findUsers() {
        return userDao.findUsers();
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public void deleteUser(String stuId) {
        userDao.deleteUser(stuId);
    }

    @Override
    public void deleteMUser(List<String> stuIds) {
        userDao.deleteMUser(stuIds);
    }

    @Override
    public void updateMUser(User user, String oldstuId) {
        userDao.updateMUser(user,oldstuId);
    }


}
