package com.laptrinhoop.dao;

import com.laptrinhoop.entity.Category;

import java.util.List;

public interface ICategoryDAO extends IGeneralDAO<Category, Integer> {
//	Category findById(Integer id);
//
	List<Category> findAll();
//
//	Category create(Category category);
//
//	void update(Category category);
//
//	Category delete(Integer id);

}
