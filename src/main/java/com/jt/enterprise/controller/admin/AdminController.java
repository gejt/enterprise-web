package com.jt.enterprise.controller.admin;


import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jt.enterprise.controller.BaseController;
import com.jt.enterprise.domain.Users;
import com.jt.enterprise.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController  extends BaseController{

	@Resource
	UserService userService;
	@RequestMapping
	public String index() {
		return "redirect:/admin/index";
	}
	
	@RequestMapping("/index")
	public String indexPage() {
		return "/admin/index";
	}

	@RequestMapping("/login")
	public String loginPage(Map<String, Object> map) {
		map.put("msg", "null");
		return "/admin/login";
	}

	@RequestMapping("/loginSubmit")
	public String login(HttpServletRequest request, String userName,
			String password, Boolean rememberMe, String verifyCode, Model model) {
		model.addAttribute("userName",userName);
		try {

			Subject currentUser = SecurityUtils.getSubject();

			if (!currentUser.isAuthenticated()) {

				if (!isVerifyCodeChecked(request, verifyCode)) {
					model.addAttribute("msg", "验证码错误");
					return "/admin/login";
				}

				if (rememberMe == null) {
					rememberMe = false;
				}

				String md5Pwd = new Md5Hash(password, userName).toString().toUpperCase();

				UsernamePasswordToken token = new UsernamePasswordToken(
						userName, md5Pwd, rememberMe);
				SecurityUtils.getSubject().login(token);
				Users user = userService.getByUserName(userName);
				SecurityUtils.getSubject().getSession().setAttribute("LOGIN_USER", user);
				return "redirect:/admin/index";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "用户名或密码错误");
		}
		return "/admin/login";
	}

	@RequestMapping("logout")
	public String logout(String userName, String password, Model model) {
		SecurityUtils.getSubject().logout();
		return "login";
	}

	
	@RequestMapping("/welcome")
	public String welcome(){
		return "/admin/welcome";
	}
}
