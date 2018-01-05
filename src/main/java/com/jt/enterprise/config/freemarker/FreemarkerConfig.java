package com.jt.enterprise.config.freemarker;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
public class FreemarkerConfig {
	
	@Bean
	public FreeMarkerViewResolver viewResolverFtl(){
		FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
		resolver.setViewClass(org.springframework.web.servlet.view.freemarker.FreeMarkerView.class);
		resolver.setSuffix(".ftl");
		resolver.setContentType("text/html;charset=UTF-8");
		resolver.setExposeRequestAttributes(true);
		resolver.setExposeSessionAttributes(true);
		resolver.setExposeSpringMacroHelpers(true);
		resolver.setRequestContextAttribute("request");
		resolver.setCache(true);
		resolver.setOrder(0);
		return resolver;
	}

}
