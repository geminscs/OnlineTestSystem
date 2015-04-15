package com.train.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.train.daos.IGradeDao;
import com.train.models.Grade;

@Service
public class GradeServiceImpl implements IGradeService{
	
	@Autowired
	private IGradeDao gradeDao;
	
	public void saveGrade(Grade grade) {
		gradeDao.saveGrade(grade);
	}

	public void updateGrade(Grade grade) {
		gradeDao.updateGrade(grade);
	}

	public void deleteGrade(int id) {
		gradeDao.deleteGrade(id);
	}

	public Grade findById(int id) {
		return gradeDao.findById(id);
	}

	public List<Grade> findByStudentId(String studentId) {
		return gradeDao.findByStudentId(studentId);
	}

	public List<Grade> findByTestId(int testId) {
		return gradeDao.findByTestId(testId);
	}

	public Grade findByStudentIdAndTestId(String studentId, int testId) {
		return gradeDao.findByStudentIdAndTestId(studentId, testId);
	}

}
