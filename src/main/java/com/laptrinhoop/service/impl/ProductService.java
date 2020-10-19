package com.laptrinhoop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhoop.dao.IProductDAO;
import com.laptrinhoop.entity.Product;
import com.laptrinhoop.service.IProductService;

@Service
public class ProductService implements IProductService {

	@Autowired
	private IProductDAO dao;

	@Override
	public List<Product> findByKeywords(String keyWords) {
		return dao.findByKeywords(keyWords);
	}

	@Override
	public Product findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<Product> findAllProductByCategory(int id) {		 
		return dao.findByCategoryId(id);
	}


}
