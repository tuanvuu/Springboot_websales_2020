package com.laptrinhoop.dao;

import java.util.List;

import com.laptrinhoop.entity.Customer;

public interface ICustomerDAO extends IGeneralDAO<Customer, String> {
	List<Customer> findByRoles(boolean roles);

}
