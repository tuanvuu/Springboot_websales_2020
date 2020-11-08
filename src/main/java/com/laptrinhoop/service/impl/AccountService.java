package com.laptrinhoop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhoop.dao.ICustomerDAO;
import com.laptrinhoop.entity.Customer;
import com.laptrinhoop.service.IAccountService;
import com.laptrinhoop.service.IHttpService;
import com.laptrinhoop.service.IMailService;

@Service
public class AccountService extends GeneralService<Customer, String> implements IAccountService {

	@Autowired
	private ICustomerDAO dao;

	@Autowired
	private IHttpService http;

	@Autowired
	private IMailService mailer;

	@Override
	public Customer findById(String id) {
		return dao.findById(id);
	}

	@Override
	public void updateUser(Customer user) {
		dao.update(user);
	}

	@Override
	public boolean sendActivedUser(Customer user) {
		String to = user.getEmail();
		String subject = "Welcome to WEB SALES ";
		String url = http.getCurrentUrl().replace("register", "activate/" + http.encode(user.getId()));
		String body = "<a href='" + url + "'>Click to activate your account!</a>";
		return mailer.send(to, subject, body);
	}

	@Override
	public List<Customer> findByRoles(boolean roles) {
		return dao.findByRoles(roles);
	}

}
