package com.train.services;

import java.util.List;

import com.train.models.TestQuestion;

public interface ITestQuestionService {
	public void saveTestQuestion(TestQuestion testQustion);
	public void updataTestQuestion(TestQuestion testQuestion);
	public void delteTestQuestion(int id);
	public TestQuestion findById(int id);
	public List<TestQuestion> findByTestId(int testId);
}
