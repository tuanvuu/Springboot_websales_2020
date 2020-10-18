package com.laptrinhoop.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.laptrinhoop.dao.IGeneralDAO;
@Transactional
public class GeneraDAO<L, K> implements IGeneralDAO<L, K> {

	@Autowired
	SessionFactory factory;

	@Override
	public L create(L entity) {

		return null;
	}

	@Override
	public void update(L entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public L delete(@SuppressWarnings("unchecked") K... ids) {

		return null;
	}

	/**
	 * Truy vấn một thực thể từ CSDL
	 * 
	 * @param id là mã của thể cần tìm
	 * @return thực thể được truy vấn hoặc null nếu thực thể không tồn tại
	 */

	@Override
	public L findById(K id) {
		Session session = factory.getCurrentSession();
		Class<L> entityClass = this.getEntityClass();
		L entity = session.find(entityClass, id);
		return entity;
	}

	/**
	 * Lấy kiểu của tham số generic đầu tiên (E) của EShopDAO<E, K>
	 * 
	 * @return là kiểu của E
	 */
	@SuppressWarnings({ "unchecked" })
	private Class<L> getEntityClass() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		return (Class<L>) type.getActualTypeArguments()[0];
	}

	@Override
	public List<L> findAll() {
		Session session = factory.getCurrentSession();
		String hql = "FROM " + this.getEntityClass().getSimpleName();
		TypedQuery<L> query = session.createQuery(hql, this.getEntityClass());
		List<L> entity = query.getResultList();
		return entity;
	}

}
