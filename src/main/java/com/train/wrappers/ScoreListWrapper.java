package com.train.wrappers;

import com.train.models.Grade;
import com.train.models.Student;

public class ScoreListWrapper {
	private Grade grade;
	private Student student;
	public ScoreListWrapper(Grade grade, Student student) {
		super();
		this.grade = grade;
		this.student = student;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
}
