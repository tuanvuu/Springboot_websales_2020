package com.laptrinhoop.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.laptrinhoop.entity.Category;
import com.laptrinhoop.service.ICategoryService;

@Component
public class CommonInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private ICategoryService service;

	// chuẩn bị dữ liệu cho giao diện dùng chung với category
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		List<Category> list = service.findAll();
		modelAndView.addObject("cates", list);
	}

}
