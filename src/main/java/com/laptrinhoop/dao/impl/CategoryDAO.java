package com.laptrinhoop.dao.impl;

import org.springframework.stereotype.Repository;

import com.laptrinhoop.dao.ICategoryDAO;
import com.laptrinhoop.entity.Category;


@Repository
public class CategoryDAO extends GeneraDAO<Category, Integer> implements ICategoryDAO {

}
