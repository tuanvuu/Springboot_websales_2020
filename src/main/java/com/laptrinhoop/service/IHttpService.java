package com.laptrinhoop.service;

public interface IHttpService {
	// lấy ra địa chỉ của url hiện tại trang web đang gọi tới
	String getCurrentUrl();

    // lấy ra địa chỉ của uri
	String getCurrentUri();
}
