package com.jt.enterprise.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.code.kaptcha.impl.DefaultKaptcha;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping
	public String index() {
		return "index";
	}
	
	@RequestMapping("index")
	public String indexPage() {
		return "index";
	}

	@RequestMapping("login")
	public String loginPage(Map<String, Object> map) {
		return "login";
	}

	@RequestMapping("loginSubmit")
	public String login(HttpServletRequest request, String userName,
			String password, Boolean rememberMe, String verifyCode, Model model) {
		try {

			Subject currentUser = SecurityUtils.getSubject();

			if (!currentUser.isAuthenticated()) {

				if (!isVerifyCodeChecked(request, verifyCode)) {
					model.addAttribute("msg", "验证码错误");
					return "login";
				}

				if (rememberMe == null) {
					rememberMe = false;
				}

				String md5Pwd = new Md5Hash(password, userName).toString().toUpperCase();

				UsernamePasswordToken token = new UsernamePasswordToken(
						userName, md5Pwd, rememberMe);
				SecurityUtils.getSubject().login(token);
				return "index";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "用户名或密码错误");
		}
		return "login";
	}

	private boolean isVerifyCodeChecked(HttpServletRequest request,
			String verifyCode) {
		String captchaId = (String) request.getSession().getAttribute(
				"vrifyCode");
		return captchaId.equals(verifyCode);
	}

/*	@RequestMapping("logout")
	public String logout(String userName, String password, Model model) {
		SecurityUtils.getSubject().logout();
		return "login";
	}*/

	@Resource
	DefaultKaptcha defaultKaptcha;

	@RequestMapping("/defaultKaptcha")
	public void defaultKaptcha(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		byte[] captchaChallengeAsJpeg = null;
		ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
		try {
			// 生产验证码字符串并保存到session中
			String createText = defaultKaptcha.createText();
			httpServletRequest.getSession().setAttribute("vrifyCode",
					createText);
			// 使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
			BufferedImage challenge = defaultKaptcha.createImage(createText);
			ImageIO.write(challenge, "jpg", jpegOutputStream);
		} catch (IllegalArgumentException e) {
			httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		// 定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
		captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
		httpServletResponse.setHeader("Cache-Control", "no-store");
		httpServletResponse.setHeader("Pragma", "no-cache");
		httpServletResponse.setDateHeader("Expires", 0);
		httpServletResponse.setContentType("image/jpeg");
		ServletOutputStream responseOutputStream = httpServletResponse
				.getOutputStream();
		responseOutputStream.write(captchaChallengeAsJpeg);
		responseOutputStream.flush();
		responseOutputStream.close();
	}
}
