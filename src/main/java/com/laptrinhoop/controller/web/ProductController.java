package com.laptrinhoop.controller.web;

import java.util.List;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.laptrinhoop.entity.Category;
import com.laptrinhoop.entity.Product;
import com.laptrinhoop.service.ICategoryService;
import com.laptrinhoop.service.ICookieService;
import com.laptrinhoop.service.IProductService;

@Controller
public class ProductController {

	@Autowired
	private ICategoryService service;

	@Autowired
	private IProductService serviceProduct;

	@Autowired
	private ICookieService cookieService;

	@RequestMapping("/product/list-by-category/{cId}")
	public String listByCategory(@PathVariable("cId") Integer id, Model model) {
		Category category = service.findById(id);
		List<Product> listProduct = category.getProducts();
		model.addAttribute("list", listProduct);
		return "product/list";

	}

	@RequestMapping("/product/list-by-keywords")
	public String listByKeyWords(@RequestParam("keywords") String keywords, Model model) {
		List<Product> listP = serviceProduct.findByKeywords(keywords);
		model.addAttribute("list", listP);
		return "product/list";

	}

	@RequestMapping("/product/detail/{id}")
	public String detail(@PathVariable("id") Integer id, Model model) {
		Product p = serviceProduct.findById(id);
		model.addAttribute("prod", p);
		model.addAttribute("list", serviceProduct.findAllProductByCategory(p.getCategory().getId()));
		return "product/detail";
	}

	@ResponseBody
	@RequestMapping("/product/add-to-like/{id}")
	public boolean addProductLike(@PathVariable("id") Integer id, Model model) {
		Cookie cookieLike = cookieService.read("like"); // lấy cookie từ client lên với tên like
		String value = id.toString();
		// kiểm tra cookie nếu có tên đó
		// có là do trc đây họ có thêm rồi, bây giờ họ thêm tiếp
		if (cookieLike != null) {
			value = cookieLike.getValue(); // lấy giá trị của cookie và gán vào biến
			// để kiểm tra trong giá trị có trùng hay không
			if (!value.contains(id.toString())) {
				value += "," + id.toString();
			} else {
				return false;
			}

		}
		// xong tạo một cookie mới vừa được gán thêm vô một id sp
		cookieService.create("like", value, 15);
		return true;
	}

}
