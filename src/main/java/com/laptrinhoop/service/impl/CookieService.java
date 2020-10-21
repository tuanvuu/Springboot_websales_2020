package com.laptrinhoop.service.impl;

import java.util.Base64;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhoop.service.ICookieService;

@Service
public class CookieService implements ICookieService {

	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;

	@Override
	public Cookie create(String name, String value, int day) {
		String enCode = Base64.getEncoder().encodeToString(value.getBytes()); // đổi sang mảng byte giá trị đã đc mã hóa
		Cookie cookie = new Cookie(name, enCode);
		cookie.setMaxAge(day * 24 * 60 * 60); // đặt thời gian tồn tại ( tính theo giây)
		cookie.setPath("/"); // đường dẫn mọi url trong web
		response.addCookie(cookie); // gửi về lại cho client
		return cookie;
	}

//	@Override
//	public Cookie read(String name) {
//		// đọc cookie từ client lên thông qua req
//		Cookie[] cookies = request.getCookies();
//		if (cookies != null) {
//			for (Cookie cookie : cookies) {
//				if (cookie.getName().equalsIgnoreCase(name)) {
//					String coverToString = new String(Base64.getDecoder().decode(cookie.getValue()));
//					cookie.setValue(coverToString);
//					return cookie;
//				}
//			}
//		}
//		return null;
//	}

	/**
	 * Đọc và giải mã cookie
	 * 
	 * @param name         tên cookie cần đọc
	 * @param defaultValue giá trị mặc định
	 * @return giá trị đã giải mã cookie nếu tồn tại hoặc defaultValue nếu không tồn
	 *         tại
	 */
	public String getCookieValue(String name, String defaultValue) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equalsIgnoreCase(name)) {
					return this.decode(cookie.getValue());
				}
			}
		}
		return defaultValue;
	}

	@Override
	public void delete(String name) {
		this.create(name, "", 0);

	}

	/**
	 * Giải mã chuỗi được mã hóa dạng Base64
	 * 
	 * @param encodedText là chuỗi mã hóa
	 * @return chuỗi đã giải mã
	 */
	public String decode(String encodedText) {
		return new String(Base64.getDecoder().decode(encodedText));
	}



}
