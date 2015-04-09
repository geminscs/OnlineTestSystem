package com.train.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String Login(){
		return "login";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public void Login_Post(String name, String password, String type, HttpServletResponse response) throws IOException{
		 response.setContentType("text/plain");
		 PrintWriter out = response.getWriter();
		 out.println("Get post data:" + name + password + type);
	}

	@RequestMapping(value="/env", method=RequestMethod.GET)
	public void env(HttpServletResponse response) throws IOException {
	    response.setContentType("text/plain");
	    PrintWriter out = response.getWriter();
	    out.println("System Environment:\n");
	}
}
