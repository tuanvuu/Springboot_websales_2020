package com.laptrinhoop.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhoop.service.IHttpService;

@Service
public class HttpService implements IHttpService {
	@Autowired
	private HttpServletRequest req;

	@Override
	public String getCurrentUrl() {
		return req.getRequestURL().toString();
	}

	@Override
	public String getCurrentUri() {

		return req.getRequestURL().toString();
	}

}
