package com.laptrinhoop.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.laptrinhoop.dao.IProductDAO;
import com.laptrinhoop.entity.Product;
import com.laptrinhoop.service.ICartService;

@SessionScope
@Service("cart")
public class CartService implements ICartService {

	@Autowired
	private IProductDAO daoProduct;

	Map<Integer, Product> map = new HashMap<Integer, Product>();

	@Override
	public void addCart(Integer id) {
		Product p = map.get(id);
		if (p != null) { // đã có trong giỏ hàng
			p.setQuantity(p.getQuantity() + 1);
		} else { // chưa có => lấy từ CSDL
			p = daoProduct.findById(id);
			p.setQuantity(1);
			map.put(id, p);
		}
	}

	/**
	 * Xóa sản phẩm khỏi giỏ
	 * 
	 * @param id mã sản phẩm cần xóa
	 */
	@Override
	public void removeCart(Integer id) {
		map.remove(id);
	}

	/**
	 * Cập nhật số lượng sản phẩm trong giỏ
	 * 
	 * @param id  mã sản phẩm cần thay đổi số lượng
	 * @param qty số lượng mới
	 */
	@Override
	public void updateCart(Integer id, int qty) {
		Product product = map.get(id);
		product.setQuantity(qty);
	}

	@Override
	public void clear() {
		map.clear();
	}

	/**
	 * Tính tổng số lượng
	 */
	@Override
	public int getCountCart() {
		Collection<Product> product = this.getItemsCart();
		int count = 0;
		for (Product p : product) {
			count += p.getQuantity();
		}
		return count;
	}

	/**
	 * Tính tổng tiền
	 */
	@Override
	public double getAmountCart() {
		Collection<Product> ps = this.getItemsCart();
		double amount = 0;
		for (Product product : ps) {
			amount += (product.getQuantity() * product.getUnitPrice() - (1 - product.getDiscount()));
		}

		return amount;
	}

	/**
	 * Lấy tập hợp các sản phẩm trong giỏ
	 * @return Collection<Product> chứa các mặt hàng trong giỏ
	 */
	@Override
	public Collection<Product> getItemsCart() {
		return map.values();
	}

}
