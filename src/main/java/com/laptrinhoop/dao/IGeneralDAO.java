package com.laptrinhoop.dao;

import java.util.List;

public interface IGeneralDAO<L, K> {
	L create(L entity); // thêm một thực thể

	void update(L entity);

	L delete(@SuppressWarnings("unchecked") K... ids);

	L findById(K id);

    List<L> findAll();

}
