package com.jt.enterprise.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="users_role")
public class UsersRole {
	@Id
	@GeneratedValue
    private Long id;

    private Long usersId;

    private Long roleId;

    private Date createTime;

}