package com.laptrinhoop.service;

import javax.servlet.http.Cookie;

public interface ICookieService {
	Cookie create(String name,String value,int day);
	Cookie read(String name);
	void delete(String name);			

}
