package com.jt.enterprise.query;

import com.jt.common.core.Pager;
import com.jt.enterprise.domain.Users;

import lombok.Data;

@Data
public class UserQuery extends Pager<Users>{
	
	private static final long serialVersionUID = 1L;
	private String userName;
	private String userNameLike;
	private String nickNameLike;
	
	private String orderBy;
	private String direction = "ASC";
	
}
