package com.train.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.train.daos.IQuestionDao;
import com.train.models.Question;

@Service
public class QuestionServiceImpl implements IQuestionService {
	
	@Autowired
	private IQuestionDao questionDao;

	public void saveQuestion(Question qustion) {
		questionDao.saveQuestion(qustion);
	}

	public void updateQuestion(Question question) {
		questionDao.updateQuestion(question);
	}

	public void deleteQuestion(int id) {
		questionDao.deleteQuestion(id);
	}

	public Question findById(int id) {
		return questionDao.findById(id);
	}

	public List<Question> findByCatagoryAndType(String catagory, int type) {
		return questionDao.findByCatagoryAndType(catagory, type);
	}

}
