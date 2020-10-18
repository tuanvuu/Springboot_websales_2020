package com.laptrinhoop.dao;

import java.util.List;

import com.laptrinhoop.entity.Customer;

public interface ICustomerDAO {
	Customer findById(String id);

	List<Customer> findAll();

	Customer create(Customer category);

	void update(Customer category);

	Customer delete(Integer id);

}
