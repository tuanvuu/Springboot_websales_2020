package com.laptrinhoop.dao.impl;

import org.springframework.stereotype.Service;

import com.laptrinhoop.dao.IOrderDetailDAO;
import com.laptrinhoop.entity.OrderDetail;
@Service
public class OrderDetailDAO extends GeneraDAO<OrderDetail, Integer> implements IOrderDetailDAO{

}
