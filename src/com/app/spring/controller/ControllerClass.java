package com.app.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.spring.pojo.MyUser;

import com.app.spring.service.ServiceClass;

import static com.app.spring.mailer.MyMailer.*;
@Controller
@RequestMapping(value="/main")
public class ControllerClass {

	@Autowired
	private ServiceClass sc;
	
	//@Autowired
	//private MailSender mailSender;
	
	
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String registerUser(MyUser user1)
	{
		
		//map.addAttribute("user1", new UserHibPOJO());
		return "register";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerUser(MyUser user1, HttpSession hs)
	{
		sc.addUser(user1);
		try {
			//sendMail("watever", "prongzz.nil@gmail.com", "rhtpatil912@gmail.com", "watever");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "redirect:/index";
	}
	
	
	@RequestMapping(value="/validate",method=RequestMethod.GET)
	public String validateUser(Model map,MyUser user1)
	{
		System.out.println("in validate get");
		//map.addAttribute("user1", new UserHibPOJO());
		//map.addAttribute("user1", new MyUser());
		return "validate";
	}
	
	@RequestMapping(value="/validate",method=RequestMethod.POST)
	public String validateUser(MyUser user1, Model map,HttpSession hs)
	{
		System.out.println("in validate Post"+user1);
		MyUser u1=null;
		//map.addAttribute("user1", new UserHibPOJO());
		
		try {
			u1=sc.validate(user1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(u1);
		if(u1!=null)
		{
			hs.setAttribute("loggedUser", u1);
			map.addAttribute("user", u1);
			return "redirect:/bookService";
		}
		
		else return "index";
	}		
}