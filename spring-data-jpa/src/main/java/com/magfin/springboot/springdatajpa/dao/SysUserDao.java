package com.magfin.springboot.springdatajpa.dao;

import com.magfin.springboot.springdatajpa.model.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.io.Serializable;

public interface SysUserDao extends JpaRepository<SysUser, Long>, QuerydslPredicateExecutor<SysUser>, Serializable {

}