package com.laptrinhoop.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.laptrinhoop.service.ICategoryService;

@Controller
public class HomeController {
	@Autowired
	private ICategoryService serviceCategory;

	@RequestMapping("/home/index")
	public String index() {
		return "home/index";
	}

	@RequestMapping("/home/about")
	public String about() {
		return "home/about";
	}

	@RequestMapping("/home/contact")
	public String contact() {
		return "home/contact";
	}

	@RequestMapping("/home/feedback")
	public String feedback() {
		return "home/feedback";
	}

	@RequestMapping("/home/faq")
	public String faq() {
		return "home/faq";
	}

	@RequestMapping("/home/aside/category")
	public String category(Model model) {
		model.addAttribute("cates", serviceCategory.findAll());
		return "non-layout/layout/_aside-category";
	}
}
