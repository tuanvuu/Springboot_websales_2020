package com.laptrinhoop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhoop.dao.ICategoryDAO;
import com.laptrinhoop.entity.Category;
import com.laptrinhoop.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private ICategoryDAO dao;

	@Override
	public List<Category> findAll() {
		return dao.findAll();
	}

	@Override
	public Category findById(Integer id) {
		return dao.findById(id);
	}

}
