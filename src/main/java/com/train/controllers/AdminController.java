package com.train.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.train.models.Student;
import com.train.models.Teacher;
import com.train.services.ITeacherService;
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
public class AdminController {
	@Autowired
	private ITeacherService teacherService;
	
	@RequestMapping(value="/Admin", method=RequestMethod.GET)
	public String mainHomePage(){
		return "admin";
	}
	
	@RequestMapping(value="/AdminSetting", method=RequestMethod.GET)
	public String MainSetting(){
		return "revisePasswordAdmin";
	}
	
	@RequestMapping(value="/AdminSetting", method=RequestMethod.POST)
	public void AdminSetting_POST(String oldPassword, String newPassword, HttpServletResponse response, HttpSession session) throws IOException{
		String account = (String) session.getAttribute("t_account");
		Teacher t = teacherService.findbyAccount(account);
		response.setContentType("text/plain;");
		PrintWriter out = response.getWriter();
		if(t != null){
			if(t.getPassword().equals(oldPassword)){
				t.setPassword(newPassword);
				teacherService.updateTeacher(t);
				out.println("Revise succussfully");
			}
			else{
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);		
				out.println("Wrong password");
			}
		}
		else{
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);		
			out.println("No such teacher");
		}
	}
	
}