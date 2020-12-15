package com.laptrinhoop.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.laptrinhoop.entity.Category;
import com.laptrinhoop.entity.Customer;
import com.laptrinhoop.service.ICategoryService;
import com.laptrinhoop.service.IHttpService;

@Component
public class SecurityInterceptor implements HandlerInterceptor {
	@Autowired
	private IHttpService http;

	@Autowired
	private ICategoryService cateService;

	@SuppressWarnings("deprecation")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// lấy ds cates đưa vào combobox
		List<Category> list = cateService.findAll();
		request.setAttribute("cates", list);
		
		Customer user = http.getSession("user");
		String url = request.getRequestURI(); // lưu lại url user muốn truy cập

		if (user == null) {
			http.setSession("security-uri", url); // đưa vào attribute
			response.sendRedirect("/account/login?message="
					+ java.net.URLEncoder.encode("Bạn cần phải đăng nhập trước khi sử dụng chức năng"));
			return false;
		} else {
			if (!user.isAdmin()) {
				if (url.contains("/admin/")) {
					response.sendRedirect("/account/login?message="
							+ java.net.URLEncoder.encode("Bạn không có quyền vào trang admin !!"));
					return false;
				}
			}
			return true;
		}

	}

}
