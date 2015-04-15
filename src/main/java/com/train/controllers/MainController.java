package com.train.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.train.models.Grade;
import com.train.models.Student;
import com.train.models.Test;
import com.train.models.TestQuestion;
import com.train.services.IGradeService;
import com.train.services.ITestQuestionService;
import com.train.services.ITestService;
import com.train.services.IUserService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.train.services.IStudentService;
import com.train.wrappers.TestWrapper;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {
	@Autowired  
	 private IStudentService studentService;
	 @Autowired  
	 private IUserService userService;
	 
	 @Autowired
	 private ITestService testService;
	 
	 @Autowired
	 private ITestQuestionService testQuestionService;
	 
	 @Autowired
	 private IGradeService gradeService;
	
	 private static final int selectValue = 2;
	 private static final int judgeValue = 2;
	
	@RequestMapping(value="/Main", method=RequestMethod.GET)
	public String MainHomePage(){
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
	
	@RequestMapping(value="/FormalTest", method=RequestMethod.GET)
	public String FormalTest(Model model){
		long time = System.currentTimeMillis();
		model.addAttribute("testWrapper", TestWrapper.generateTestWrapper(testService.findAllByTime(time)));
		return "accessibleTest";
	}
	
	@RequestMapping(value="/StartTest", method=RequestMethod.POST)
	public String FormalTest_POST(String ID, Model model,HttpServletResponse response ,HttpSession session){
		int testId = Integer.parseInt(ID);
		String account = (String)session.getAttribute("s_account");
		if(account == null){
			return "redirect:/";
		}
		Student student = studentService.findbyAccount(account);
		if(student == null){
			return "redirect:/";
		}
		Grade grade = gradeService.findByStudentIdAndTestId(account, testId);
		if(grade == null){
			grade = new Grade();
			grade.setStudentId(account);
			grade.setTestId(testId);
			grade.setStartTime(System.currentTimeMillis());
			grade.setEndTime(-1);
			grade.setSelectGrade(-1);
			grade.setJudgeGrade(-1);
			grade.setShortEssayGrade(-1);
			grade.setTotalGrade(-1);
			gradeService.saveGrade(grade);
		}
		else if(grade.getSelectGrade() >= 0){
			PrintWriter out;
			try {
				out = response.getWriter();
				out.println("You have attended this exam");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return null;
		}
		Test test = testService.findbyId(testId);
		List<TestQuestion> testQuestionType0 = testQuestionService.findByTestIdAndType(testId, 0);
		List<TestQuestion> testQuestionType1 = testQuestionService.findByTestIdAndType(testId, 1);
		List<TestQuestion> testQuestionType2 = testQuestionService.findByTestIdAndType(testId, 2);
		
		model.addAttribute("testWrapper", new TestWrapper(test));
		model.addAttribute("testQuestionType0", testQuestionType0);
		model.addAttribute("testQuestionType1", testQuestionType1);
		model.addAttribute("testQuestionType2", testQuestionType2);
		return "testPaper";
	}
	
	@RequestMapping(value="/FormalTestJudge", method=RequestMethod.POST)
	public String JudgeForTest(String jsonString, String testID, HttpServletResponse response, HttpSession session){
		String account = (String)session.getAttribute("s_account");
		int testId = Integer.parseInt(testID);
		PrintWriter out;
		
		if(account == null){
			return "redirect:/";
		}
		Student student = studentService.findbyAccount(account);
		if(student == null){
			return "redirect:/";
		}
		try {
			out = response.getWriter();		
			JSONArray jsonArray = new JSONArray(jsonString);
			int selectScore = 0, judgeScore = 0;
			for(int i = 0;i < jsonArray.length();i ++){
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				int questionId = Integer.parseInt(jsonObject.getString("ID"));
				TestQuestion testQuestion = testQuestionService.findById(questionId);
				if(testQuestion.getTestId() != testId){
					out.println("Error");
					return null;
				}
				if(testQuestion.getType() == 0){
					if(testQuestion.getAnsShort() == Integer.parseInt(jsonObject.getString("answer"))){
						selectScore += selectValue;
					}
				}
				else if(testQuestion.getType() == 1){
					if(testQuestion.getAnsShort() == Integer.parseInt(jsonObject.getString("answer"))){
						judgeScore += judgeValue;
					}
				}
			}
			
			Grade grade = gradeService.findByStudentIdAndTestId(account, testId);
			if(grade == null){
				out.println("Error:Can not create grade");
			}
			else{
				grade.setEndTime(System.currentTimeMillis());
				grade.setSelectGrade(selectScore);
				grade.setJudgeGrade(judgeScore);
				grade.setTotalGrade(selectScore + judgeScore);
				gradeService.updateGrade(grade);
				out.println("Submit successfully "+selectScore + " " + judgeScore);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
