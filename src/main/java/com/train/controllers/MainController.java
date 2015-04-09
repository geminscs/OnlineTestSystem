package com.train.controllers;

import com.train.services.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.train.services.IStudentService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {
	@Autowired  
	 private IStudentService studentService;
	 @Autowired  
	 private IUserService userService; 
	
	
	@RequestMapping(value="/Main", method=RequestMethod.GET)
	public String mainHomePage(){
		return "main";
	}
	
}
