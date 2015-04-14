package com.train.wrappers;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.train.models.Test;

public class TestWrapper {
	private String formatStartTime;
	private String formatEndTime;
	private Test test;
	
	public TestWrapper(Test t){
		test = t;
		Date date = new Date(t.getStartTime());
		GregorianCalendar gc = new GregorianCalendar();   
        gc.setTime(date);  
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");  
        formatStartTime = format.format(gc.getTime());  
        
        date = new Date(t.getEndTime());
        gc.setTime(date);
        formatEndTime = format.format(gc.getTime());
	}
		
	public TestWrapper() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public String getFormatStartTime() {
		return formatStartTime;
	}

	public void setFormatStartTime(String formatStartTime) {
		this.formatStartTime = formatStartTime;
	}

	public String getFormatEndTime() {
		return formatEndTime;
	}

	public void setFormatEndTime(String formatEndTime) {
		this.formatEndTime = formatEndTime;
	}

	public String getStartDate(){
		return formatStartTime.substring(0, formatStartTime.indexOf(" "));
	}
	
	public String getStartTime(){
		return formatStartTime.substring(formatStartTime.indexOf(" ") + 1);
	}
	
	public String getEndDate(){
		return formatEndTime.substring(0, formatEndTime.indexOf(" "));
	}
	
	public String getEndTime(){
		return formatEndTime.substring(formatEndTime.indexOf(" ") + 1);
	}
	
	public static List<TestWrapper> generateTestWrapper(List<Test> l){
		List<TestWrapper> wrapperList = new ArrayList<TestWrapper>();
		for(int i = 0;i < l.size();i ++){
			wrapperList.add(new TestWrapper(l.get(i)));
		}
		return wrapperList;
	}
}
