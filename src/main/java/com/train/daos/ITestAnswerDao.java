package com.train.daos;

import java.util.List;

import com.train.models.TestAnswer;

public interface ITestAnswerDao {
	public void saveTestAnswer(TestAnswer testAnswer);
	
	public void updataTestAnswer(TestAnswer testAnswer);
	
	public void delteTestAnswer(int id);
	
	public void deleteTestAnswerByTestId(int testId);
	
	public TestAnswer findById(int id);
		
	public List<TestAnswer> findByTestIdAndStudentId(int testId, String studetId);
}
