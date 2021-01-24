package com.gradu.dao;

import com.gradu.entity.Admin;

public interface IAdminDao {
    //查找用户
    Admin findAdminByAid(String aid);
}
