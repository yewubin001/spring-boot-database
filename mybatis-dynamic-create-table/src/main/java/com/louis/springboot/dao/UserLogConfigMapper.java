package com.louis.springboot.dao;

import java.util.List;

import com.louis.springboot.model.UserLogConfig;

public interface UserLogConfigMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserLogConfig record);

    int insertSelective(UserLogConfig record);

    UserLogConfig selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserLogConfig record);

    int updateByPrimaryKey(UserLogConfig record);

    public List<UserLogConfig> selectAll();
}