package com.jt.enterprise.filter;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;

import com.jt.enterprise.Application;

@Component
@ServletComponentScan
@WebFilter(urlPatterns = "/*",filterName = "loginFilter")
public class AppFilter implements Filter{
	@Resource
	Application app;
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain fc) throws IOException, ServletException {
		request.setAttribute("APP", app);
		fc.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig fc) throws ServletException {
		
	}
	
}
