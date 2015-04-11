package com.train.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.train.models.Student;
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
	
	@RequestMapping(value="/MainSetting", method=RequestMethod.GET)
	public String MainSetting(){
		return "revisePasswordMain";
	}
	
	@RequestMapping(value="/MainSetting", method=RequestMethod.POST)
	public void MainSetting_POST(String oldPassword, String newPassword, HttpServletResponse response, HttpSession session) throws IOException{
		String account = (String) session.getAttribute("s_account");
		Student s = studentService.findbyAccount(account);
		response.setContentType("text/plain;");
		PrintWriter out = response.getWriter();
		if(s != null){
			if(s.getPassword().equals(oldPassword)){
				s.setPassword(newPassword);
				studentService.updateStudent(s);
				out.println("Revise succussfully");
			}
			else{
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);		
				out.println("Wrong password");
			}
		}
		else{
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);		
			out.println("No such student");
		}
	}
	
}
