package com.magfin.springboot.springdatajpa.controller;

import com.magfin.springboot.springdatajpa.model.SysUser;
import com.magfin.springboot.springdatajpa.service.SysUserService;
import com.magfin.springboot.springdatajpa.util.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @PostMapping(value = "/save")
    public Object save(@RequestBody SysUser user) {
        sysUserService.save(user);
        return 1;
    }

    @PostMapping(value = "/delete")
    public Object delete(@RequestBody SysUser user) {
        sysUserService.delete(user);
        return 1;
    }

    @GetMapping(value = "/findAll")
    public Object findAll() {
        return sysUserService.findAll();
    }


    @PostMapping(value = "/findPage")
    public Page<SysUser> findPage(@RequestBody PageQuery pageQuery) {
        return sysUserService.findPage(pageQuery);
    }

    @GetMapping(value = "/findPage2")
    public Page<SysUser> findPage(Pageable pageable, SysUser sysUser) {
        return sysUserService.findPage(pageable, sysUser);
    }

    @GetMapping(value = "/findPage3")
    public Page<SysUser> findByPage(Pageable pageable, SysUser sysUser) {
        return sysUserService.findByPage(pageable, sysUser);
    }

    @GetMapping(value = "/findAllByPage")
    public Page<SysUser> findAllByPage(Pageable pageable, SysUser sysUser) {
        return sysUserService.findAllByPage(pageable, sysUser);
    }

}