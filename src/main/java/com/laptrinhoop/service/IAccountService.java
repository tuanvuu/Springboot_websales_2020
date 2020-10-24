package com.laptrinhoop.service;

import com.laptrinhoop.entity.Customer;

public interface IAccountService {
	Customer findById(String id);
	Customer createUser(Customer user);
	boolean sendActivedUser(Customer user);
	void updateUser(Customer user);

}
