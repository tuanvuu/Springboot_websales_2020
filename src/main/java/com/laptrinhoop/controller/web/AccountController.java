package com.laptrinhoop.controller.web;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.laptrinhoop.dao.ICustomerDAO;
import com.laptrinhoop.entity.Customer;
import com.laptrinhoop.service.IAccountService;
import com.laptrinhoop.service.ICookieService;
import com.laptrinhoop.service.IHttpService;
import com.laptrinhoop.service.IMailService;

@Controller
public class AccountController {

	@Autowired
	private IAccountService accountSerive;
	
	@Autowired
	private ICustomerDAO customerDAO;

	@Autowired
	private IHttpService http;
	@Autowired
	private ICookieService cookieService;

	@Autowired
	private IMailService mailerService;

	@GetMapping("/account/login")
	public String login(Model model) {
		String[] userInfo = cookieService.getCookieValue("user", " , ").split(",");
		model.addAttribute("username", userInfo[0]);
		model.addAttribute("password", userInfo[1]);
		return "account/login";
	}

	@PostMapping("/account/login")
	public String login(Model model, @RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam(name = "remember", defaultValue = "false") boolean remember) {
		Customer user = accountSerive.findById(username);
		if (user == null) {
			model.addAttribute("message", "Sai tên đăng nhập");
		} else if (!password.equals(user.getPassword())) {
			model.addAttribute("message", "Sai mật khẩu");
		} else if (!user.isActivated()) {
			model.addAttribute("message", "Vui lòng vào mail kích hoạt tài khoản");
		} else {
			http.setSession("user", user);
			model.addAttribute("message", "Đăng nhập thành công");
			if (remember) {
				cookieService.createCookie("user", username + "," + password, 15);
			} else {
				cookieService.deleteCookie("user");
			}
		}
		return "account/login";
	}

	@GetMapping("/account/forgot")
	public String forgot() {
		return "account/forgot";

	}

	@PostMapping("/account/forgot")
	public String forgot(Model model, @RequestParam("username") String username, @RequestParam("email") String email) {
		Customer user = accountSerive.findById(username);
		if (user == null) {
			model.addAttribute("message", "Sai tên đăng nhập");
		} else if (!user.getEmail().equals(email)) {
			model.addAttribute("message", "Sai tên email đã đăng kí");
		} else {
			mailerService.send(email, "Forgot Password", user.getPassword());
			model.addAttribute("message", "Mật khẩu đã được gửi qua email");
			return "redirect:/account/login?message=" + model.getAttribute("message");
		}
		return "account/forgot";

	}

	@GetMapping("/account/register")
	public String register(Model model) {
		Customer user = new Customer();
		model.addAttribute("user", user);
		return "account/register";

	}

	@PostMapping("/account/register")
	public String register(Model model, @RequestParam("photo_file") MultipartFile file,
			@RequestParam("confirm") String confirm, @Validated @ModelAttribute("user") Customer form,
			BindingResult errors) {
		if (errors.hasErrors()) {
			model.addAttribute("message", "Vui lòng không bỏ trống !");
		} else if (!confirm.equals(form.getPassword())) {
			model.addAttribute("message", "Xác nhận password không trùng khớp!");
		} else {
			Customer user = accountSerive.findById(form.getId());
			if (user != null) {
				model.addAttribute("message", "Tài khoản user đã được dùng!");
			} else if (!accountSerive.sendActivedUser(form)) {
				model.addAttribute("message", "Không thể gửi email kích hoạt!");
			} else {
				File photo = http.saveCustomerPhoto(file);
				if (photo != null) {
					form.setPhoto(photo.getName());
				} else {
					form.setPhoto("user.png");
				}
				accountSerive.createUser(form);
				model.addAttribute("message", "Kiểm tra email và kích hoạt tài khoản!");

				return "redirect:/account/login?message=" + model.getAttribute("message");
			}
		}
		return "account/register";
	}
	@GetMapping("/account/activate/{id}")
	public String activate(Model model, @PathVariable("id") String id) {
		Customer user = accountSerive.findById(http.decode(id));
		user.setActivated(true);
		customerDAO.update(user);	
		model.addAttribute("message", "Tài khoản đã được kích hoạt");
		return "redirect:/account/login?message=" + model.getAttribute("message");
	}

}
