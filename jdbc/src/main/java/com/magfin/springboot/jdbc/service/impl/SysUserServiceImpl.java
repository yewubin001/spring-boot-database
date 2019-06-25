package com.magfin.springboot.jdbc.service.impl;

import com.magfin.springboot.jdbc.dao.SysUserDao;
import com.magfin.springboot.jdbc.model.SysUser;
import com.magfin.springboot.jdbc.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public void save(SysUser user) {
        sysUserDao.save(user);
    }

    @Override
    public void delete(String id) {
        sysUserDao.delete(id);
    }

    @Override
    public List<SysUser> findAll() {
        return sysUserDao.findAll();
    }

}