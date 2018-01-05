package com.jt.enterprise.service;

import com.jt.common.service.IService;
import com.jt.enterprise.domain.Users;

public interface UserService extends IService<Users>{
	
	Integer register(Users user);
	
	Users getByUserName(String userName);
}
