package com.app.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.spring.model.BrandService;
import com.app.spring.pojo.MyUser;
import com.app.spring.pojo.ServiceProvider;
import com.app.spring.pojo.Servicetype;
import com.app.spring.service.ServiceClass;




@Controller(value="/home")
public class ControllerHome {

	private static ArrayList<String> cityLs=new ArrayList<String>();
	private static ArrayList<String> serviceTypes=new ArrayList<>();
	private static ArrayList<String> brands =new ArrayList<>();
	private static List<Servicetype> ls;
	private static ArrayList<ServiceProvider> spList=new ArrayList<ServiceProvider>();
	@Autowired
	ServiceClass service;
	
	
	@PostConstruct
	public void getDetails()
	{
		ls=service.getServiceTypes();
		System.out.println(ls+"in postConstruct");
		for (Servicetype servicetype : ls) {
			serviceTypes.add(servicetype.getRequesttype());
		}
		
		
		cityLs.add("Pune");
		brands.add("BMW");
		brands.add("Honda");
		brands.add("maruti");
		
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession hs)
	{
		System.out.println("inlogout");
		hs.setAttribute("loggedUser", null);
		return "redirect:/bookService";
	}
	
	@RequestMapping("/bookService")
	public String populateLists(Model m,MyUser myUser, BrandService b,HttpSession hs)
	{
		
		m.addAttribute("centerList", cityLs);
		m.addAttribute("servicetypes", serviceTypes);
		m.addAttribute("brands", brands);
		
		m.addAttribute(b);
		
		return "bookService";
	}
	
	
	
	
	@RequestMapping(value="/bookService",method=RequestMethod.POST)
	  public String postMethod(Model m,BrandService b,BindingResult br,HttpSession hs )
	  {
		/*MyUser loggedUser=(MyUser)hs.getAttribute("loggedUser");
		System.out.println("checking whether logged in or not>?"+loggedUser);
		
		if(loggedUser!=null && loggedUser.getId()>0)
		{
			m.addAttribute("ifSuccess","Logged In Successfully");
			
	
		}
		 */
		
		hs.setAttribute("selectedBrands", service.getSPbyBrand(b.getBrand()));
		return "redirect:/serviceCenters";
		}
		
	
	
	
		@RequestMapping("/serviceCenters")
		public String showServiceCenterView(Model m,MyUser user1,HttpServletRequest request)
		{
			
			return "serviceCenters";
		}
		
		
		@RequestMapping(value="/serviceCenters",method=RequestMethod.POST)
		public String selectedSP(@RequestParam String selected,Model m,HttpServletRequest request,HttpSession hs)
		{
		
			MyUser loggedUser=(MyUser)hs.getAttribute("loggedUser");
			System.out.println("checking whether logged in or not>?"+loggedUser);
			
			if(loggedUser==null || loggedUser.getId()<0)
			{
				return "index";
			}
			
			
			ServiceProvider obj=new  ServiceProvider();
			ArrayList<ServiceProvider> ls=(ArrayList<ServiceProvider>) hs.getAttribute("selectedBrands");
			for (ServiceProvider s : ls) {
				if(s.getId()==Integer.parseInt(selected))
					obj=s;
				hs.setAttribute("selectedsp",obj);
				
				
							
				if(loggedUser!=null){
			
					//Servicerequest sr= new Servicerequest();
					//sr.setCid(loggedUser.getID());
					//sr.setSpid(obj.getId());
					//sr.setServicetype(new Servicetype());
					
				}
			}
			
			return "redirect:/dashboardUser";
		}
		
	  
	
	
	
}




