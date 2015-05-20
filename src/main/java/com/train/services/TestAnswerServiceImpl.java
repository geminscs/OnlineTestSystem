package com.train.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.train.daos.ITestAnswerDao;
import com.train.models.TestAnswer;

@Service
public class TestAnswerServiceImpl implements ITestAnswerService {

	@Autowired
	private ITestAnswerDao testAnswerDao;
	
	public void saveTestAnswer(TestAnswer testAnswer) {
		testAnswerDao.saveTestAnswer(testAnswer);
	}

	public void updataTestAnswer(TestAnswer testAnswer) {
		testAnswerDao.updataTestAnswer(testAnswer);
	}

	public void delteTestAnswer(int id) {
		testAnswerDao.delteTestAnswer(id);
	}

	public void deleteTestAnswerByTestId(int testId) {
		testAnswerDao.deleteTestAnswerByTestId(testId);
	}

	public TestAnswer findById(int id) {
		return testAnswerDao.findById(id);
	}

	public List<TestAnswer> findByTestIdAndStudentId(int testId, String studetId) {
		return testAnswerDao.findByTestIdAndStudentId(testId, studetId);
	}

}
