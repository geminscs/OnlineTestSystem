package com.train.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="test_question")
public class TestQuestion {
	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;
	
	@Column(name="test_id")
	private Integer testId;
	
	@Column(name="content")
	private String content;
	
	@Column(name="ans_short")
	private int ansShort;
	
	@Column(name="ans_long")
	private String ansLong;
	
	@Column(name="type")
	private int type;
	
	@Column(name="value")
	private int value;
	
	@Column(name="a")
	private String A;
	
	@Column(name="b")
	private String B;
	
	@Column(name="c")
	private String C;
	
	@Column(name="d")
	private String D;

	public TestQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestQuestion(Integer id, Integer testId, String content,
			int ansShort, String ansLong, int type, int value, String a,
			String b, String c, String d) {
		super();
		this.id = id;
		this.testId = testId;
		this.content = content;
		this.ansShort = ansShort;
		this.ansLong = ansLong;
		this.type = type;
		this.value = value;
		A = a;
		B = b;
		C = c;
		D = d;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getAnsShort() {
		return ansShort;
	}

	public void setAnsShort(int ansShort) {
		this.ansShort = ansShort;
	}

	public String getAnsLong() {
		return ansLong;
	}

	public void setAnsLong(String ansLong) {
		this.ansLong = ansLong;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getA() {
		return A;
	}

	public void setA(String a) {
		A = a;
	}

	public String getB() {
		return B;
	}

	public void setB(String b) {
		B = b;
	}

	public String getC() {
		return C;
	}

	public void setC(String c) {
		C = c;
	}

	public String getD() {
		return D;
	}

	public void setD(String d) {
		D = d;
	}
	
	
}
