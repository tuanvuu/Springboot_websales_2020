package com.laptrinhoop.service;

import java.util.List;

import com.laptrinhoop.entity.Category;

public interface ICategoryService {
	List<Category> findAll();

	Category findById(Integer id);

}
