package com.laptrinhoop.service;

import java.util.List;

import com.laptrinhoop.entity.Category;

public interface ICategoryService extends IGeneralService<Category, Integer> {
	List<Category> getRamDomByCategory();
}
