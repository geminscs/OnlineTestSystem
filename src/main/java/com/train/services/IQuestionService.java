package com.train.services;

import java.util.List;

import com.train.models.Question;

public interface IQuestionService {
	
	public void saveQuestion(Question qustion);	
	public void updateQuestion(Question question);	
	public void deleteQuestion(int id);	
	public Question findById(int id);	
	public List<Question> findByCatagoryAndType(String catagory, int type);
	
}
