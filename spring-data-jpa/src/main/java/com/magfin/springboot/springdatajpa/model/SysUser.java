package com.magfin.springboot.springdatajpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

/**
 * // @Entity: 实体类, 必须
 * // @Table: 对应数据库中的表, 必须, name=表名, Indexes是声明表里的索引,
 * // columnList是索引的列, 同时声明此索引列是否唯一, 默认false
 */
@Entity
@Table(name = "sys_user",
        indexes = {@Index(name = "id", columnList = "id", unique = true),
                @Index(name = "name", columnList = "name", unique = true)
        })
public class SysUser implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Id: 指明id列, 必须
    @Id
    // @GeneratedValue： 表明是否自动生成, 必须, strategy也是必写, 指明主键生成策略, 默认是Oracle
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column： 对应数据库列名,可选, nullable 是否可以为空, 默认true
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "create_time")
    private Instant createTime;

    public Instant getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}