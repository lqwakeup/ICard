package com.gradu.dao.impl;

import com.gradu.dao.IUserDao;
import com.gradu.entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "userDao")
public class UserDaoImpl implements IUserDao {

    @Autowired
    private QueryRunner runner;

    public User findUserByStuId(String stuId) {
        try{
            List<User> users =runner.query("select * from user where stuId = ?", new BeanListHandler<User>(User.class),stuId);
            if(users.size()==0){
                return null;
            }
            if(users.size()>1){
                throw new RuntimeException("结果集不唯一，数据有问题");
            }
            return users.get(0);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<User> findUsers() {
        try {
            List<User> users = runner.query("select * from user",new BeanListHandler<User>(User.class));
            return users;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateUser(User user) {
        try{
            runner.update("update user set password =? where stuId = ?",user.getPassword(),user.getStuId());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertUser(User user) {
        try{
            runner.update("insert into user(stuId,name,sex,cardId,bankCard,descs)values(?,?,?,?,?,?)"
                    ,user.getStuId(),user.getName(),user.getSex(),user.getCardId(),user.getBankCard(),user.getDescs());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteUser(String stuId) {
        try{
            runner.update("delete from user where stuId = ?",stuId);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteMUser(List<String> stuIds) {
        try{
            for(String stuId:stuIds){
                runner.update("delete from user where stuId = ?",stuId);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateMUser(User user,String oldstuId) {
        try{
            runner.update("update user set stuId=?,name=?,sex=?,cardId=?, bankCard=?,descs=? where stuId=?",user.getStuId(),
                    user.getName(),user.getSex(),user.getCardId(),user.getBankCard(),user.getDescs(),oldstuId);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
