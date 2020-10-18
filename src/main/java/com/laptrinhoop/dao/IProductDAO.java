package com.laptrinhoop.dao;

import java.util.List;

import com.laptrinhoop.entity.Product;

public interface IProductDAO {
	Product findById(Integer id);

	List<Product> findAll();

	Product create(Product product);

	void update(Product category);

	Product delete(Integer id);

	List<Product> findByKeyWords(String keyWords);

}
