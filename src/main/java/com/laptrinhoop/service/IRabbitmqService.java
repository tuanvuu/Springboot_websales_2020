package com.laptrinhoop.service;

import com.laptrinhoop.entity.Order;
import com.laptrinhoop.service.impl.CartService;

public interface IRabbitmqService {
	public void converToSendRabbit(Order o, CartService cart);

}
