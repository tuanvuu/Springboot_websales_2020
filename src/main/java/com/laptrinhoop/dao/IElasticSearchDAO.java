package com.laptrinhoop.dao;

import java.util.List;

public interface IElasticSearchDAO {
	List<Object> findAllProductByKeywords(String keywords);

	List<Object> findAllProductByCategory(Integer id);

}
