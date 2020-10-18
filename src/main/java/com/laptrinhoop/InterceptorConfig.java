package com.laptrinhoop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.laptrinhoop.interceptor.CommonInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	
	
	@Autowired
	private CommonInterceptor share;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(share).addPathPatterns("/**");
	}

}
