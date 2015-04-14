package com.train.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.train.models.Teacher;
import com.train.models.Test;
import com.train.services.ITeacherService;
import com.train.services.ITestService;
import com.train.wrappers.TestWrapper;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AdminController {
	@Autowired
	private ITeacherService teacherService;
	
	@Autowired
	private ITestService testService;
	
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
	
	@RequestMapping(value="/EditTest", method=RequestMethod.GET)
	public String EditTest(Model model){
		List<Test>list = testService.findAllTests();
		List<TestWrapper> wrapperList = TestWrapper.generateTestWrapper(list);
		model.addAttribute("testWrapper", wrapperList);
		return "editTest";
	}
	
	@RequestMapping(value="/AddTest", method=RequestMethod.POST)
	public void AddTest(String jsonString, HttpServletResponse response){
		 try {
		    	Test test = new Test();
				JSONObject jsonObject = new JSONObject(jsonString);
				String startTime = jsonObject.getString("startDate") + " " +jsonObject.getString("startTime");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
				long millionSeconds = sdf.parse(startTime).getTime();
				test.setStartTime(millionSeconds);
				
				String endTime = jsonObject.getString("endDate") + " " +jsonObject.getString("endTime");
				millionSeconds = sdf.parse(endTime).getTime();
				test.setEndTime(millionSeconds);
				
				if(test.getStartTime() > test.getEndTime()){
					//return badRequest("结束时间不能早于开始时间");
				}
				
				
				test.setDuration(Integer.parseInt(jsonObject.getString("duration")));
				if(test.getDuration() <= 0){
					response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
					PrintWriter out = response.getWriter();
					out.println("Start time cannot be bigger than end time");
					return;
				}
				testService.saveTest(test);
				PrintWriter out = response.getWriter();
				out.println(""+test.getId());
				return;
				
			} catch (Exception e) {
				// TODO Auto-generated catch block	
				e.printStackTrace();
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				PrintWriter out;
				try {
					out = response.getWriter();
					out.println("Fail to parse json string");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return;
			}
	}
}