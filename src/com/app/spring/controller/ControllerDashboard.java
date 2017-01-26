package com.app.spring.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.spring.model.Datecheckboxmodel;
import com.app.spring.pojo.MyUser;
import com.app.spring.pojo.ServiceProvider;
import com.app.spring.pojo.Servicerequest;
import com.app.spring.service.ServiceClass;


@Controller
public class ControllerDashboard {

	@Autowired
	ServiceClass service;
	
	
	
	
	
	@RequestMapping("/dashboardUser")
	public String userDashboardGet(Model m, Datecheckboxmodel dc,HttpSession hs,HttpServletRequest request){
		
		
		MyUser loggedUser = (MyUser) hs.getAttribute("loggedUser");
		m.addAttribute("datecheckboxmodel",dc);
		if(loggedUser==null)
			return "redirect:/bookService";
		
		ArrayList<Servicerequest> ls=(ArrayList<Servicerequest>) service.getUserRequests(loggedUser.getId());
		ArrayList<Servicerequest> pending=new ArrayList<Servicerequest>();
	
		for (Servicerequest servicerequest : ls) {
			if(servicerequest.getIsprocessed()==0)
				pending.add(servicerequest);
		}
		
		
		System.out.println("in dashboard get"+ls);
		m.addAttribute("allrequests",ls);
		m.addAttribute("pending",pending);
		
		
		return "dashboardUser";
	}
	
	
	@RequestMapping(value="/dashboardUser",method=RequestMethod.POST)
	public String userDashboardPost(Model m,
			Servicerequest sr,
			HttpSession hs,
			Datecheckboxmodel ds
			/*@RequestParam("ispd") String ispd,
			@RequestParam @DateTimeFormat(pattern="dd.MM HH:mm") LocalDate aldate,*/
			
			)
	{
ServiceProvider sp=(ServiceProvider)hs.getAttribute("selectedsp");
		
		
MyUser loggedUser = (MyUser) hs.getAttribute("loggedUser");
		System.out.println(ds);
		System.out.println(sr);
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss.SSS");
		try {
			// 
				Date d=	sdf.parse(ds.getAldate()+":00.000");
				System.out.println(d);
				Timestamp t=new Timestamp(d.getTime());
			//System.out.println(t);
		
		sr.setSpid(sp.getId());
		sr.setCid(loggedUser.getId());
		if(ds.isIspd())
			sr.setIspickdrop(1);
		sr.setReqdate(t);
		System.out.println(sr);
		
		//Servicerequest obj=service.getSrById(Integer.parseInt(selected));
		//if(obj==null)
		System.out.println(service.placeOrder(sr));
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println((Servicerequest) hs.getAttribute("request"));
		return "redirect:/dashboardUser";
	}
	
	
}
