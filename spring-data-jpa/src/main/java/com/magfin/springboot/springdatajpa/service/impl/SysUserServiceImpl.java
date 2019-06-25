package com.magfin.springboot.springdatajpa.service.impl;

import com.magfin.springboot.springdatajpa.dao.SysUserDao;
import com.magfin.springboot.springdatajpa.model.QSysUser;
import com.magfin.springboot.springdatajpa.model.SysUser;
import com.magfin.springboot.springdatajpa.service.SysUserService;
import com.magfin.springboot.springdatajpa.util.PageQuery;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public void save(SysUser user) {
        sysUserDao.save(user);
    }

    @Override
    public void delete(SysUser user) {
        sysUserDao.delete(user);
    }

    @Override
    public List<SysUser> findAll() {
        return sysUserDao.findAll();
    }

    /**
     * 单表不带条件的分页查询
     *
     * @param pageQuery
     * @return
     */
    @Override
    public Page<SysUser> findPage(PageQuery pageQuery) {
        return sysUserDao.findAll(PageRequest.of(pageQuery.getPage(), pageQuery.getSize()));
    }

    /**
     * 单表带条件的分页查询
     *
     * @param pageable
     * @param sysUser
     * @return
     */
    @Override
    public Page<SysUser> findPage(Pageable pageable, SysUser sysUser) {
        QSysUser user = QSysUser.sysUser;

        /**组装查询条件*/
        BooleanExpression expression = user.id.isNotNull();
        if (StringUtils.isNotBlank(sysUser.getName())) {
            expression = expression.and(user.name.like(StringUtils.wrap(sysUser.getName(), "%")));
        }
        if (StringUtils.isNotBlank(sysUser.getEmail())) {
            expression = expression.and(user.email.eq(sysUser.getEmail()));
        }
        //按照创建时间降序排列
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
        PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);

        return sysUserDao.findAll(expression, pageRequest);

    }

    /**
     * 适用单表带条件的查询所有字段分页查询
     *
     * @param pageable
     * @param sysUser
     * @return
     */
    @Override
    public Page<SysUser> findByPage(Pageable pageable, SysUser sysUser) {
        QSysUser user = QSysUser.sysUser;

        /**组装查询条件*/
        BooleanExpression expression = user.id.isNotNull();
        if (StringUtils.isNotBlank(sysUser.getName())) {
            expression = expression.and(user.name.like(StringUtils.wrap(sysUser.getName(), "%")));
        }
        List<SysUser> userList = jpaQueryFactory.selectFrom(user)
                .where(expression)
                .orderBy(user.createTime.asc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        long count = jpaQueryFactory.selectFrom(user)
                .where(expression).fetchCount();
        return new PageImpl<>(userList, pageable, count);
    }

    /**
     * 能实现所有情况的复杂查询
     *
     * @param pageable
     * @param sysUser
     * @return
     */
    @Override
    public Page<SysUser> findAllByPage(Pageable pageable, SysUser sysUser) {
        QSysUser user = QSysUser.sysUser;

        /**组装查询条件*/
        BooleanExpression expression = user.id.isNotNull();
        if (StringUtils.isNotBlank(sysUser.getName())) {
            expression = expression.and(user.name.like(StringUtils.wrap(sysUser.getName(), "%")));
        }
        if (StringUtils.isNotBlank(sysUser.getEmail())) {
            expression = expression.and(user.email.eq(sysUser.getEmail()));
        }

        /**查询结果*/
        JPAQuery<SysUser> sysUserJPAQuery = jpaQueryFactory
                .select(Projections.bean(SysUser.class, user.id, user.name, user.email, user.createTime))
                .from(user)
                .where(expression)
                .orderBy(user.id.asc());
        List<SysUser> list = sysUserJPAQuery.offset(pageable.getOffset()).limit(pageable.getPageSize()).fetch();

        return new PageImpl<>(list, pageable, sysUserJPAQuery.fetchCount());
    }


}