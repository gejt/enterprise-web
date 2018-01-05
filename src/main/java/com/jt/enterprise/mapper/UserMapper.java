package com.jt.enterprise.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jt.common.core.Pager;
import com.jt.enterprise.domain.Users;

public interface UserMapper {

	Users getOne(Long id);
	
	List<Users> getAll();
	
	int insert(Users user);

	int update(Users user);

	int delete(Long id);

	List<Users> queryList(@Param("query") Pager<Users> pager);

	int queryCount(@Param("query") Pager<Users> pager);

	Users getByUserName(String userName);

}