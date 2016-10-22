package com.nike.controller;

import com.nike.dao.DAO;
import com.nike.util.CloudinaryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@Autowired
	private DAO dao;

	@RequestMapping("/index")
	public ModelAndView printWelcome(@RequestParam(value = "category", required=false) String category) {
		CloudinaryUtil.getCloudinary();
		category = category == null ? "category1" : category;
		System.out.println(category);
		ModelAndView model = new ModelAndView("index");
		model.addObject("lists", dao.getProductsList(category));
		return model;
	}

	@RequestMapping("/login")
	public ModelAndView loginPage() {
		ModelAndView model = new ModelAndView("login");
		return model;
	}
}