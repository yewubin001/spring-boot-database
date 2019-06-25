package com.magfin.springboot.jdbc.service;

import com.magfin.springboot.jdbc.model.SysUser;

import java.util.List;

public interface SysUserService {

    /**
     * 保存用户
     *
     * @param user
     */
    public void save(SysUser user);

    /**
     * 删除用户
     *
     * @param id
     */
    public void delete(String id);

    /**
     * 查询全部用户
     *
     * @return
     */
    public List<SysUser> findAll();

}