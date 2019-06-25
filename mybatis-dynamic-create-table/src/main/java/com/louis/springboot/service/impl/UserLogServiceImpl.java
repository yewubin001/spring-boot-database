package com.louis.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.springboot.dao.UserLogMapper;
import com.louis.springboot.model.UserLog;
import com.louis.springboot.service.UserLogService;

@Service
public class UserLogServiceImpl implements UserLogService {

    @Autowired
    private UserLogMapper userLogMapper;

    @Override
    public void save(String tableName, UserLog userLog) {
        // 插入
        userLogMapper.insertSelective(tableName, userLog);
    }

    @Override
    public List<UserLog> findAll(String tableName) {
        return userLogMapper.selectAll(tableName);
    }
}