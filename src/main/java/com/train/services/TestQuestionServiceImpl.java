package com.train.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.train.daos.ITestQuestionDao;
import com.train.models.TestQuestion;

@Service
public class TestQuestionServiceImpl implements ITestQuestionService{

	@Autowired
	private ITestQuestionDao testQuestionDao;
	
	public void saveTestQuestion(TestQuestion testQustion) {
		testQuestionDao.saveTestQuestion(testQustion);
	}

	public void updataTestQuestion(TestQuestion testQuestion) {
		testQuestionDao.updataTestQuestion(testQuestion);
	}

	public void delteTestQuestion(int id) {
		testQuestionDao.delteTestQuestion(id);
	}

	public TestQuestion findById(int id) {
		return testQuestionDao.findById(id);
	}

	public List<TestQuestion> findByTestId(int testId) {
		return testQuestionDao.findByTestId(testId);
	}

	public List<TestQuestion> findByTestIdAndType(int testId, int type) {
		return testQuestionDao.findByTestIdAndType(testId, type);
	}

	public void deleteTestQuestionByTestId(int testId) {
		testQuestionDao.deleteTestQuestionByTestId(testId);
	}

}
