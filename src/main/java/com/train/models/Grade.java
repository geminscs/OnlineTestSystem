package com.train.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="grade")
public class Grade {
	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;
	
	@Column(name="student_id")
	private String studentId;
	
	@Column(name="test_id")
	private Integer testId;
	
	@Column(name="start_time")
	private long startTime;
	
	@Column(name="end_time")
	private long endTime;
	
	@Column(name="select_grade")
	private Integer selectGrade;
	
	@Column(name="judge_grade")
	private Integer judgeGrade;
	
	@Column(name="short_essay_grade")
	private Integer shortEssayGrade;
	
	@Column(name="total_grade")
	private Integer totalGrade;

	public Grade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Grade(Integer id, String studentId, Integer testId, long startTime,
			long endTime, Integer selectGrade, Integer judgeGrade,
			Integer shortEssayGrade, Integer totalGrade) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.testId = testId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.selectGrade = selectGrade;
		this.judgeGrade = judgeGrade;
		this.shortEssayGrade = shortEssayGrade;
		this.totalGrade = totalGrade;
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

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public Integer getSelectGrade() {
		return selectGrade;
	}

	public void setSelectGrade(Integer selectGrade) {
		this.selectGrade = selectGrade;
	}

	public Integer getJudgeGrade() {
		return judgeGrade;
	}

	public void setJudgeGrade(Integer judgeGrade) {
		this.judgeGrade = judgeGrade;
	}

	public Integer getShortEssayGrade() {
		return shortEssayGrade;
	}

	public void setShortEssayGrade(Integer shortEssayGrade) {
		this.shortEssayGrade = shortEssayGrade;
	}

	public Integer getTotalGrade() {
		return totalGrade;
	}

	public void setTotalGrade(Integer totalGrade) {
		this.totalGrade = totalGrade;
	}
	
	
}
