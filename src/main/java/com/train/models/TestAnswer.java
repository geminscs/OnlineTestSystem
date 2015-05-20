package com.train.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="test_answer")
public class TestAnswer {
	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;
	
	@Column(name="student_id")
	private String studentId;
	
	@Column(name="test_id")
	private Integer testId;
	
	@Column(name="question_id")
	private Integer QuestionId;
	
	@Column(name="answer")
	private String answer;
	
	public TestAnswer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestAnswer(Integer id, String studentId, Integer testId,
			Integer questionId, String answer) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.testId = testId;
		QuestionId = questionId;
		this.answer = answer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public Integer getQuestionId() {
		return QuestionId;
	}

	public void setQuestionId(Integer questionId) {
		QuestionId = questionId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	
}
