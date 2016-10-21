package com.nike.controller;

import com.nike.dao.DAOImpl;
import com.nike.util.CloudinaryUtil;
import com.nike.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/index")
	public ModelAndView printWelcome(@RequestParam(value = "category", required=false) String category) {
		CloudinaryUtil.getCloudinary();
		category = category == null ? "category1" : category;
		System.out.println(category);
		ModelAndView model = new ModelAndView("index");
		model.addObject("lists", new DAOImpl().getProductsList(category));
		return model;
	}
}