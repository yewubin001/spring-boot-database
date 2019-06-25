package com.magfin.springboot.springdatajpa.service;

import com.magfin.springboot.springdatajpa.model.SysUser;
import com.magfin.springboot.springdatajpa.util.PageQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SysUserService {

    /**
     * 保存用户
     *
     * @param user
     */
    void save(SysUser user);

    /**
     * 删除用户
     *
     * @param user
     */
    void delete(SysUser user);

    /**
     * 查询全部用户
     *
     * @return
     */
    List<SysUser> findAll();

    /**
     * 适用单表简单的分页查询
     *
     * @return
     */
    Page<SysUser> findPage(PageQuery pageQuery);

    /**
     * 适用单表带条件的分页查询
     *
     * @param pageable
     * @param sysUser
     * @return
     */
    Page<SysUser> findPage(Pageable pageable, SysUser sysUser);

    /**
     * 适用单表带条件的分页查询
     *
     * @param pageable
     * @param sysUser
     * @return
     */
    Page<SysUser> findByPage(Pageable pageable, SysUser sysUser);

    /**
     * 实现复杂的分页查询
     *
     * @param pageable
     * @param sysUser
     * @return
     */
    Page<SysUser> findAllByPage(Pageable pageable, SysUser sysUser);


}