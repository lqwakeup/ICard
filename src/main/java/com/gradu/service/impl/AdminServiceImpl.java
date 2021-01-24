package com.gradu.service.impl;

import com.gradu.dao.IAdminDao;
import com.gradu.entity.Admin;
import com.gradu.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private IAdminDao adminDao;

    @Override
    public Admin findAdminByAid(String aid) {
        return adminDao.findAdminByAid(aid);
    }
}
