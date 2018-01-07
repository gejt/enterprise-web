package com.jt.enterprise.controller;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
	
	public boolean isVerifyCodeChecked(HttpServletRequest request,
			String verifyCode) {
		String captchaId = (String) request.getSession().getAttribute(
				"vrifyCode");
		return captchaId.equals(verifyCode);
	}
	
	
}
