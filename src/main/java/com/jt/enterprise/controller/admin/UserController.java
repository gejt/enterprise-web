package com.jt.enterprise.controller.admin;

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
@RequestMapping("admin/user")
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	@Resource UserService userService;
	@RequestMapping
	public String index(Map<String,Object> map){  
		return "admin/user/user-list";
	}
	
	@RequestMapping("query")
	@ResponseBody
	public Pager<Users> query(UserQuery query){
		return  userService.queryPager(query);
	}
}
