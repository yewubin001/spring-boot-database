package com.louis.springboot.service;

import java.util.List;

import com.louis.springboot.model.SysUser;

public interface SysUserService {

    /**
     * 查找所有用户
     *
     * @return
     */
    List<SysUser> findAll();

}