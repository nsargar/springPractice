package com.app.spring.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;



@Controller

public class ControllerUpload {

	private static final String UPLOAD_LOCATION 
	= "d:/";
	
	
	
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String uploadContent(@RequestParam MultipartFile contents,Model map)
	{
		try{
			contents.transferTo(new File(UPLOAD_LOCATION,contents.getOriginalFilename()));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return "main/index";
	}
	
	
	
}
