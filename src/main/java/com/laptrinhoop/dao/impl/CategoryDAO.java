package com.laptrinhoop.dao.impl;

import org.springframework.stereotype.Repository;

import com.laptrinhoop.dao.ICategoryDAO;
import com.laptrinhoop.entity.Category;


@Repository
public class CategoryDAO extends GeneraDAO<Category, Integer> implements ICategoryDAO {

	/*
	 * @Autowired SessionFactory factory;
	 * 
	 * @Override public Category findById(Integer id) { Session session =
	 * factory.getCurrentSession(); Category category = session.find(Category.class,
	 * id); return category; }
	 * 
	 * @Override public List<Category> findAll() { Session session =
	 * factory.getCurrentSession(); String sql = "FROM Category";
	 * TypedQuery<Category> query = session.createQuery(sql, Category.class);
	 * List<Category> list = query.getResultList(); return list; }
	 * 
	 * @Override public Category create(Category category) { Session session =
	 * factory.openSession(); Transaction t = session.beginTransaction(); try {
	 * session.save(category); t.commit();
	 * 
	 * } catch (Exception e) { System.out.println(e.toString()); t.rollback();
	 * 
	 * } finally { session.close(); } return category; }
	 * 
	 * @Override public void update(Category category) { Session session =
	 * factory.openSession(); Transaction t = session.beginTransaction(); try {
	 * session.delete(category); t.commit();
	 * 
	 * } catch (Exception e) { System.out.println(e.toString()); t.rollback();
	 * 
	 * } finally { session.close(); } }
	 * 
	 * @Override public Category delete(Integer id) { Session session =
	 * factory.openSession(); Transaction t = session.beginTransaction(); Category
	 * category = findById(id); try { session.delete(category); t.commit();
	 * 
	 * } catch (Exception e) { System.out.println(e.toString()); t.rollback();
	 * 
	 * } finally { session.close(); } return category; }
	 */

}
