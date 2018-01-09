package com.jt.enterprise.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import com.jt.common.enums.UserSexEnum;

import lombok.Data;


@Data
@Entity
@Table(name="users",indexes={@Index(unique=true, columnList = "userName")})
public class Users {
	
	@Id
	@GeneratedValue
    private Long id;

    private String userName;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserSexEnum userSex;

    private String nickName;

    private String info;

    private Date createTime;

    private Date updateTime;

    
    public Users() {
		super();
	}

	public Users(String userName, String password, UserSexEnum man) {
    	this.userName=userName;
    	this.password=password;
    	this.userSex = man;
	}
}