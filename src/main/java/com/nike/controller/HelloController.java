package com.nike.controller;

import com.nike.dao.DAO;
import com.nike.dao.UserDAO;
import com.nike.model.Order;
import com.nike.model.Products;
import com.nike.model.User;
import com.nike.util.CloudinaryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

	@Autowired
	private DAO dao;

	@Autowired
	private UserDAO userDAO;

	@RequestMapping("/addProduct")
	public ModelAndView addProductToBusket(@RequestParam(value = "productId", required=false) Integer productID) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		dao.addOrder(dao.getProductById(productID), userDAO.getUserByName2(name));
		System.out.println(name + " " + productID);
		return new ModelAndView("redirect:index");
	}

	@RequestMapping("/index")
	public ModelAndView printWelcome(@RequestParam(value = "category", required=false) String category) {
		CloudinaryUtil.getCloudinary();
		category = category == null ? "category1" : category;
		System.out.println(category);
		ModelAndView model = new ModelAndView("index");
		model.addObject("lists", dao.getProductsList(category));
		return model;
	}

	@RequestMapping(value="/loginPage")
	public ModelAndView executeLogin() {
		ModelAndView model = new ModelAndView("login");
		return model;
	}

	@RequestMapping(value="/cartPage")
	public ModelAndView cartPage() {
		ModelAndView model = new ModelAndView("cart");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		System.out.println("user" + userDAO.getUserByName2(name));
		List<Order> orders = dao.getOrdersList(userDAO.getUserByName2(name));
		List<Products> products = new ArrayList<>();
		for(Order order : orders) {
			products.add(dao.getProductById(order.getProduct_id().getProduct_id()));
		}
		model.addObject("lists", products);
		return model;
	}

	@RequestMapping(value="/regPage")
	public ModelAndView executeRegistrationPage() {
		ModelAndView model = new ModelAndView("signUpPage");
		return model;
	}

	@RequestMapping(value="/registrate")
	public ModelAndView executeRegistration(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginBean")User user) {
		userDAO.saveUser(user);
		System.out.println(user.getUsername());
		return new ModelAndView("registrate");
	}


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
							  @RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login1");

		return model;

	}
}