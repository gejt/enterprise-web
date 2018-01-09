package com.jt.enterprise.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;
@Data
@Entity
@Table(name="role")
public class Role {
	@Id
	@GeneratedValue
    private Long id;

    private String name;

    private String descs;

    private Date createTime;

    private Date updateTime;

}