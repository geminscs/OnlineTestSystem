package com.train.services;

import java.util.List;

import com.train.models.Grade;

public interface IGradeService {
	public void saveGrade(Grade grade);
	
	public void updateGrade(Grade grade);
	
	public void deleteGrade(int id);
	
	public Grade findById(int id);
	
	public List<Grade> findByStudentId(String studentId);
	
	public List<Grade> findByTestId(int testId);
	
	public Grade findByStudentIdAndTestId(String studentId, int testId);
}
