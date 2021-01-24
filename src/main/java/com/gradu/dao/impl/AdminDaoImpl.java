package com.gradu.dao.impl;

import com.gradu.dao.IAdminDao;
import com.gradu.entity.Admin;
import com.gradu.entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("adminDao")
public class AdminDaoImpl implements IAdminDao {

    @Autowired
    private QueryRunner runner;

    @Override
    public Admin findAdminByAid(String aid) {
        try{
            List<Admin> admins =runner.query("select * from admin where aid = ?", new BeanListHandler<Admin>(Admin.class),aid);
            if(admins.size()==0){
                return null;
            }
            if(admins.size()>1){
                throw new RuntimeException("结果集不唯一，数据有问题");
            }
            return admins.get(0);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
