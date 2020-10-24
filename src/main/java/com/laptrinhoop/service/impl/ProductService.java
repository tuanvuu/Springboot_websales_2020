package com.laptrinhoop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhoop.dao.IProductDAO;
import com.laptrinhoop.entity.Product;
import com.laptrinhoop.service.ICookieService;
import com.laptrinhoop.service.IProductService;

@Service
public class ProductService implements IProductService {

	@Autowired
	private IProductDAO dao;
	
	@Autowired
	private ICookieService cookieService;

	@Override
	public List<Product> findByKeywords(String keyWords) {
		return dao.findByKeywords(keyWords);
	}

	@Override
	public Product findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<Product> findAllProductByCategory(int id) {
		return dao.findByCategoryId(id);
	}

	@Override
	public List<Product> findByHot(String key) {
		return dao.findItemByHot(key);
	}

	@Override
	public List<Product> getViewProduct(String name,String id) {
		String ids = cookieService.getCookieValue(name, id.toString());
		if (!ids.contains(id.toString())) { // chưa có trong cookie
			ids += "," + id.toString();
		}
		cookieService.createCookie(name, ids, 15);	
		return dao.findByIdsInCookie(ids);  //thêm cookie xong gọi dao để truy vấn lấy danh sách
	}

	@Override
	public List<Product> getFaVoProduct(String name, String id) {
		String favos = cookieService.getCookieValue(name, "");
		if(favos.length() > 0) // có sản phẩm yêu thích
		{
			return dao.findByIdsInCookie(favos); // truyền tham số lấy tất cả sản phẩm theo mảng id sản phẩm
		}
		else
		return null;
	}

}
