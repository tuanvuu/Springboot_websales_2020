package com.laptrinhoop.dao;

import java.util.List;

import com.laptrinhoop.entity.Customer;
import com.laptrinhoop.entity.Order;
import com.laptrinhoop.service.impl.CartService;

public interface IOrderDAO extends IGeneralDAO<Order, Integer> {

	void create(Order o, CartService cart);
	List<Order> findByUser(Customer user);

}
