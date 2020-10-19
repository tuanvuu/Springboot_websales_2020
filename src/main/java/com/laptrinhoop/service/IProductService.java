package com.laptrinhoop.service;

import java.util.List;

import com.laptrinhoop.entity.Product;

public interface IProductService {
	List<Product> findByKeywords(String keyWords);

	Product findById(Integer id);
	List<Product> findAllProductByCategory(int id);

}
