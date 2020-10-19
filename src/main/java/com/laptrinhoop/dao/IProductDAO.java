package com.laptrinhoop.dao;

import java.util.List;

import com.laptrinhoop.entity.Product;

public interface IProductDAO extends IGeneralDAO<Product, Integer> {

     	List<Product> findByKeywords(String keywords);
     	List<Product> findByCategoryId(Integer id);
	

}
