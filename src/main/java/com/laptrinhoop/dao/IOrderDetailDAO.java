package com.laptrinhoop.dao;

import java.util.List;

import com.laptrinhoop.entity.OrderDetail;

public interface IOrderDetailDAO {
	OrderDetail findById(Integer id);

	List<OrderDetail> findAll();

	OrderDetail create(OrderDetail OrderDetail);

	void update(OrderDetail OrderDetail);

	OrderDetail delete(Integer id);

}
