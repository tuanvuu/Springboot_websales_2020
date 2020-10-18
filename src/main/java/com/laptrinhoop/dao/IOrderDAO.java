package com.laptrinhoop.dao;

import java.util.List;

import com.laptrinhoop.entity.Order;

public interface IOrderDAO {
	Order findById(Integer id);

	List<Order> findAll();

	Order create(Order order);

	void update(Order order);

	Order delete(Integer id);

}
