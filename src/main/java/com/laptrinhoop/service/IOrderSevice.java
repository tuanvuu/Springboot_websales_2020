package com.laptrinhoop.service;

import java.util.List;
import java.util.Map;

import com.laptrinhoop.entity.Order;
import com.laptrinhoop.entity.Product;
import com.laptrinhoop.service.impl.CartService;

public interface IOrderSevice extends IGeneralService<Order, Integer> {
	Order createOrder();
	void addOrderAndOrderDetail(Order o, CartService cart); // thêm mới đơn hàng vào db
	List<Order> getAllOrderByUser();
	Order findById(Integer id);
	Map<Integer, Product> getPurchasedItems();

}
