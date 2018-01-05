package com.jt.enterprise.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Service;

import com.jt.common.core.Pager;
import com.jt.common.service.IService;
import com.jt.enterprise.domain.Users;
import com.jt.enterprise.mapper.UserMapper;
import com.jt.enterprise.query.UserQuery;
import com.jt.enterprise.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Resource
	UserMapper userMapper;

	@Override
	public Integer register(Users user) {
		Date now = new Date();
//		String password=new SimpleHash("MD5",user.getPassword(),user.getUserName(),2).toHex();
		String password=new Md5Hash(user.getPassword(), user.getUserName()).toString().toUpperCase();
        user.setPassword(password);
        user.setCreateTime(now);
        user.setUpdateTime(now);
		return userMapper.insert(user);
	}

	@Override
	public Users getByUserName(String userName) {
		return userMapper.getByUserName(userName);
	}

	@Override
	public Pager<Users> queryPager(Pager<Users> query) {
		List<Users> users = userMapper.queryList(query);
		query.setRows(users);
		int total = userMapper.queryCount(query);
		query.setTotal(total);
		return query;
	}
}
