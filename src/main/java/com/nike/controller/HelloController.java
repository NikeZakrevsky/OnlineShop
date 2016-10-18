package com.nike.controller;

import com.nike.dao.DAOImpl;
import com.nike.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

	@RequestMapping("/")
	public String printWelcome(ModelMap model) {
		new DAOImpl().saveProduct();
		return "index";
	}
}