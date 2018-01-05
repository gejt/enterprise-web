package com.jt.enterprise.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.core.Pager;
import com.jt.common.core.Result;
import com.jt.enterprise.domain.Users;
import com.jt.enterprise.query.UserQuery;
import com.jt.enterprise.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	Logger logger = LoggerFactory.getLogger(getClass());
	@Resource UserService userService;
	@RequestMapping
	public String index(Map<String,Object> map){  
	       map.put("name", "[Angel -- 守护天使]"); 
		return "user/index";
	}
	
	@RequestMapping("query")
	@ResponseBody
	public Pager<Users> query(UserQuery query){
		return  userService.queryPager(query);
	}
}
