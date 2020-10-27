package com.laptrinhoop.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhoop.dao.ICategoryDAO;
import com.laptrinhoop.entity.Category;
import com.laptrinhoop.entity.Product;
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

	@Override
	public List<Category> getRamDomByCategory() {
		String hql = "FROM Category c WHERE size(c.products) >=4 ";
		
		List<Category> list = dao.getResultList(hql);
		Collections.shuffle(list);
		List<Category> result = new ArrayList<Category>();
		for (Category cate : list) {
			List<Product> prods = cate.getProducts();
			if (prods.size() >= 4) {
				Collections.shuffle(prods);
				cate.setProducts(prods.subList(0, 4));
				result.add(cate);
			}
		}
		return list;
	}

}
