package com.laptrinhoop.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.laptrinhoop.entity.Order;
import com.laptrinhoop.service.IOrderSevice;
import com.laptrinhoop.service.impl.CartService;

@Controller
public class OrderController {

	@Autowired
	private CartService cartService;

	@Autowired
	private IOrderSevice orderService;

	@GetMapping("/order/checkout")
	public String checkOut(Model model) {
		model.addAttribute("cart", cartService);
		// new Order
		Order order = orderService.createOrder();
		model.addAttribute("order", order);
		return "order/checkout";
	}

	@PostMapping("/order/checkout")
	public String checkOut(Model model, @Validated @ModelAttribute("order") Order or, BindingResult err) {
		if (err.hasErrors()) {
			model.addAttribute("message", "Vui lòng không bỏ trống");
			model.addAttribute("cart", cartService);
			return "order/checkout";
		}
		orderService.addOrderAndOrderDetail(or, cartService);
		cartService.clear();
		return "redirect:/order/list";
	}

	@RequestMapping("/order/list")
	public String listOrder(Model model) {
		List<Order> list = orderService.getAllOrderByUser();
		model.addAttribute("orders", list);
		return "order/list";
	}

	@RequestMapping("/order/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Order order = orderService.findById(id);
		model.addAttribute("order", order);
		return "order/detail";
	}

	@RequestMapping("/order/items")
	public String getPurchasedItems(Model model) {
		model.addAttribute("list", orderService.getPurchasedItems().values());
		return "product/list";
	}
}
