package com.app.spring.controller;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.spring.dao.Dao;
import com.app.spring.model.BrandService;
import com.app.spring.pojo.MyUser;
import com.app.spring.pojo.ServiceProvider;
import com.app.spring.service.ServiceClass;



@SuppressWarnings("unused")
@Controller
public class ControllerGlobal {

	@Autowired
	ServiceClass service;
	
	@RequestMapping(value="/*")
	public String passThrough(Model m1,ServiceProvider sp)
	{
		System.out.println("in global passthrough");
		sp.setAddress("pune");
		sp.setBrand("BMW");
		sp.setContactLandline("0233212121");
		sp.setContactMobile("9898989898");
		sp.setEmail("abc");
		sp.setName("abc");
		//service.addSP(sp);
		m1.addAttribute("errMsg", "jsfjjsfjjsf");
		
		return "redirect:/bookService";
	}

	
	
	
	
}
