package com.train.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.train.models.Grade;
import com.train.models.Student;
import com.train.models.Teacher;
import com.train.models.Test;
import com.train.models.TestAnswer;
import com.train.models.TestQuestion;
import com.train.services.IGradeService;
import com.train.services.IStudentService;
import com.train.services.ITeacherService;
import com.train.services.ITestAnswerService;
import com.train.services.ITestQuestionService;
import com.train.services.ITestService;
import com.train.wrappers.GradeWrapper;
import com.train.wrappers.ScoreListWrapper;
import com.train.wrappers.TestAnswerWrapper;
import com.train.wrappers.TestWrapper;

import org.json.JSONArray;
import org.json.JSONException;
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
	
	@Autowired
	private ITestQuestionService testQuestionService;
	
	@Autowired
	private IGradeService gradeService;
	
	@Autowired
	private IStudentService studentService;
	
	@Autowired
	private ITestAnswerService testAnswerService;
	
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
				out.print(""+test.getId());
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
	
	@RequestMapping(value="/EditPaper", method=RequestMethod.POST)
	public String editPaper(String ID, Model model){
		Test test = testService.findbyId(Integer.parseInt(ID));
		if(test != null){
			TestWrapper testWrapper = new TestWrapper(test);
			List<TestQuestion> testQuestionsType0 = testQuestionService.findByTestIdAndType(test.getId(), 0);
			List<TestQuestion> testQuestionsType1 = testQuestionService.findByTestIdAndType(test.getId(), 1);
			List<TestQuestion> testQuestionsType2 = testQuestionService.findByTestIdAndType(test.getId(), 2);
			
			model.addAttribute("testWrapper", testWrapper);
			model.addAttribute("testQuestionsType0", testQuestionsType0);
			model.addAttribute("testQuestionsType1", testQuestionsType1);
			model.addAttribute("testQuestionsType2", testQuestionsType2);
		}
		return "editPaper";
	}
	
	@RequestMapping(value="/SubmitPaper", method=RequestMethod.POST)
	public void editPaper_POST(String jsonString, String testInfoString, HttpServletResponse response){
		try {
			JSONArray jsonArray = new JSONArray(jsonString);
			JSONObject testInfoJsonObject = new JSONObject(testInfoString);
			testQuestionService.deleteTestQuestionByTestId(Integer.parseInt(testInfoJsonObject.getString("id")));
			for(int i = 0;i < jsonArray.length();i ++){
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				TestQuestion testQuestion = new TestQuestion();
				testQuestion.setTestId(Integer.parseInt(testInfoJsonObject.getString("id")));
				testQuestion.setContent(jsonObject.getString("content"));
				testQuestion.setType(jsonObject.getInt("type"));
				testQuestion.setAnsShort(-1);
				testQuestion.setAnsLong("N/A");
				testQuestion.setAnsA("N/A");
				testQuestion.setAnsB("N/A");
				testQuestion.setAnsC("N/A");
				testQuestion.setAnsD("N/A");
				testQuestion.setValue(0);
				if(testQuestion.getType() == 0){
					testQuestion.setAnsShort(Integer.parseInt(jsonObject.getString("answer")));
					testQuestion.setAnsA(jsonObject.getString("option0"));
					testQuestion.setAnsB(jsonObject.getString("option1"));
					testQuestion.setAnsC(jsonObject.getString("option2"));
					testQuestion.setAnsD(jsonObject.getString("option3"));
				}
				else if(testQuestion.getType() == 1){
					testQuestion.setAnsShort(Integer.parseInt(jsonObject.getString("answer")));
				}
				else{
					testQuestion.setAnsLong(jsonObject.getString("answer"));
					testQuestion.setValue(Integer.parseInt(jsonObject.getString("value")));
				}
				testQuestionService.saveTestQuestion(testQuestion);
			}
			PrintWriter out = response.getWriter();
			out.println("Submit successfully");
			return;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			PrintWriter out;
			try {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				out = response.getWriter();
				out.println("Fail to parse json string");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/MarkTests", method=RequestMethod.GET)
	public String markTest(Model model){
		List<TestWrapper> l = TestWrapper.generateTestWrapper(testService.findAllTests());
		model.addAttribute("list", l);
		return "selectTest";
	}
	
	@RequestMapping(value="/SelectStudent", method=RequestMethod.POST)
	public String selecStudent(String ID, Model model){
		int testId = Integer.parseInt(ID);
		List<Grade> grades = gradeService.findByTestId(testId);
		List<Student> students = new ArrayList<Student>();
		for(Grade x:grades){
			if(x.getShortEssayGrade() < 0){
				students.add(studentService.findbyAccount(x.getStudentId()));
			}
		}
		model.addAttribute("list", students);
		model.addAttribute("testId", testId);
		return "selectStudent";
	}
	
	@RequestMapping(value="/MarkStudent", method=RequestMethod.POST)
	public String markStudent(String ID, String testID, Model model){
		int testId = Integer.parseInt(testID);
		String studentId = ID;
		List<TestAnswer> testAnswers = testAnswerService.findByTestIdAndStudentId(testId, studentId);
		List<TestAnswerWrapper> wrapper = new ArrayList<TestAnswerWrapper>();
		for(TestAnswer x:testAnswers){
			wrapper.add(new TestAnswerWrapper(x, testQuestionService.findById(x.getQuestionId())));
		}
		model.addAttribute("list", wrapper);
		model.addAttribute("studentId", studentId);
		model.addAttribute("testId", testId);
		return "revise";
	}
	
	@RequestMapping(value="/FormalJudge", method=RequestMethod.POST)
	public void formalJudge(String jsonString, String testID, String studentID, HttpServletResponse response){
		try {
			JSONArray jsonArray = new JSONArray(jsonString);
			int score = 0;
			for(int i =0;i < jsonArray.length();i ++){
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				score += Integer.parseInt(jsonObject.getString("score"));
			}
			String studentId = studentID;
			int testId = Integer.parseInt(testID);
			Grade grade = gradeService.findByStudentIdAndTestId(studentId, testId);
			grade.setShortEssayGrade(score);
			gradeService.updateGrade(grade);
			
			PrintWriter out = response.getWriter();
			out.println("Submit successfully");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/StuScore", method=RequestMethod.GET)
	public String gradeStatics(Model model){
		List<TestWrapper> l = TestWrapper.generateTestWrapper(testService.findAllTests());
		model.addAttribute("list", l);
		return "scoreTestList";
	}
	
	@RequestMapping(value="/ShowScoreList", method=RequestMethod.POST)
	public String showScoreList(String ID, Model model){
		int testId = Integer.parseInt(ID);
		List<Grade> l = gradeService.findByTestId(testId);
		List<ScoreListWrapper> wrapper = new ArrayList<ScoreListWrapper>();
		for(Grade x:l){
			wrapper.add(new ScoreListWrapper(x, studentService.findbyAccount(x.getStudentId())));
		}
		model.addAttribute("list", wrapper);
		return "scoreList";
	}
	
	@RequestMapping(value="/StuAdmin", method=RequestMethod.GET)
	public String studentAdmin(Model model){
		List<Student> l = studentService.findAll();
		model.addAttribute("list", l);
		return "stuInfo";
	}
	
	@RequestMapping(value="/DeleteStudent", method=RequestMethod.POST)
	public void deleteStudent(String ID, HttpServletResponse response){
		String studentId = ID;
		List<Grade> l = gradeService.findByStudentId(studentId);
		if(l != null && l.size() > 0){
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		else{
			studentService.deleteStudent(studentId);
		}
	}
}