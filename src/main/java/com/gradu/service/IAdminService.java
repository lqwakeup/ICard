package com.gradu.service;


import com.gradu.entity.Admin;

public interface IAdminService {
    //查找用户
    Admin findAdminByAid(String aid);
}
