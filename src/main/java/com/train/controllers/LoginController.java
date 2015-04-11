package com.train.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.train.services.ITeacherService;
import com.train.services.IUserService;
import com.train.models.Teacher;
import com.train.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.train.models.Student;
import com.train.services.IStudentService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	@Autowired  
	 private IStudentService studentService;
	@Autowired
	private ITeacherService teacherService;
	 @Autowired  
	 private IUserService userService; 
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String Login(){
		return "login";
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String Logout(){
		return "redirect:/";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String Login_Post(String name, String password, String type, HttpServletResponse response, HttpSession session) throws IOException{
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		if(type.equals("student")){
			Student s = studentService.findbyAccount(name);
			if(s == null){
				out.println("No such student");
				return "redirect:/";
			}
			else{
				if(s.getPassword().equals(password)){
					out.println("Login successfully");
					session.setAttribute("s_account", name);
					return "redirect:/Main";
				}
				else{
					out.println("Wrong password");
					return "redirect:/";
				}
			}
		}
		else{
			Teacher t = teacherService.findbyAccount(name);
			if(t == null){
				out.println("No such teacher");
				return "redirect:/";
			}
			else{
				if(t.getPassword().equals(password)){
					out.println("Login successfully");
					session.setAttribute("t_account", name);
					return "redirect:/Admin";
				}
				else{
					out.println("Wrong password");
					return "redirect:/";
				}
			}
		}		
	}

	@RequestMapping(value="/env", method=RequestMethod.GET)
	public void env(HttpServletResponse response) throws IOException {
	    response.setContentType("text/plain");
	    PrintWriter out = response.getWriter();
	    out.println("System Environment:\n");
	}
}
