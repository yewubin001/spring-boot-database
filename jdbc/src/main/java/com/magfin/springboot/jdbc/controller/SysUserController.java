package com.magfin.springboot.jdbc.controller;

import com.magfin.springboot.jdbc.model.SysUser;
import com.magfin.springboot.jdbc.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(value = "/delete")
    public Object delete(@RequestParam("id") String id) {
        sysUserService.delete(id);
        return 1;
    }

    @GetMapping(value = "/findAll")
    public Object findAll() {
        return sysUserService.findAll();
    }

}