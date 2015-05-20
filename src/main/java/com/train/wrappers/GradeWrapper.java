package com.train.wrappers;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import com.train.models.Grade;

public class GradeWrapper {
	private String formatStartTime;
	private String formatEndTime;
	private Grade grade;
	
	public GradeWrapper(Grade g){
		grade = g;
		Date date = new Date(g.getStartTime());
		GregorianCalendar gc = new GregorianCalendar();   
        gc.setTime(date);  
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");  
        formatStartTime = format.format(gc.getTime());  
        
        date = new Date(g.getEndTime());
        gc.setTime(date);
        formatEndTime = format.format(gc.getTime());
	}
		
	public GradeWrapper() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
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
	
	public static List<GradeWrapper> generateTestWrapper(List<Grade> l){
		List<GradeWrapper> wrapperList = new ArrayList<GradeWrapper>();
		for(int i = 0;i < l.size();i ++){
			wrapperList.add(new GradeWrapper(l.get(i)));
		}
		return wrapperList;
	}
}
