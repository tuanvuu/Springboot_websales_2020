package com.laptrinhoop.dao.impl;

import org.springframework.stereotype.Repository;

import com.laptrinhoop.dao.ICustomerDAO;
import com.laptrinhoop.entity.Customer;
@Repository
public class CustomerDAO extends GeneraDAO<Customer, String> implements ICustomerDAO {

}
