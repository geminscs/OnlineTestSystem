package com.train.wrappers;

import com.train.models.TestAnswer;
import com.train.models.TestQuestion;

public class TestAnswerWrapper {
	private TestAnswer testAnswer;
	private TestQuestion testQuestion;
	public TestAnswerWrapper(TestAnswer testAnswer, TestQuestion testQuestion) {
		super();
		this.testAnswer = testAnswer;
		this.testQuestion = testQuestion;
	}
	public TestAnswer getTestAnswer() {
		return testAnswer;
	}
	public void setTestAnswer(TestAnswer testAnswer) {
		this.testAnswer = testAnswer;
	}
	public TestQuestion getTestQuestion() {
		return testQuestion;
	}
	public void setTestQuestion(TestQuestion testQuestion) {
		this.testQuestion = testQuestion;
	}
	
	
}
