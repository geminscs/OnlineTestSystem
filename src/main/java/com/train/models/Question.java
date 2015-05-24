package com.train.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.JSONException;
import org.json.JSONObject;

@Entity
@Table(name="question")
public class Question {
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
	
	@Column(name="catagory")
	private String catagory;
	
	@Column(name="a")
	private String ansA;
	
	@Column(name="b")
	private String ansB;
	
	@Column(name="c")
	private String ansC;
	
	@Column(name="d")
	private String ansD;

	public Question(Integer id, Integer testId, String content, int ansShort,
			String ansLong, int type, int value, String catagory, String ansA,
			String ansB, String ansC, String ansD) {
		super();
		this.id = id;
		this.testId = testId;
		this.content = content;
		this.ansShort = ansShort;
		this.ansLong = ansLong;
		this.type = type;
		this.value = value;
		this.catagory = catagory;
		this.ansA = ansA;
		this.ansB = ansB;
		this.ansC = ansC;
		this.ansD = ansD;
	}

	public Question() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public String getAnsA() {
		return ansA;
	}

	public void setAnsA(String ansA) {
		this.ansA = ansA;
	}

	public String getAnsB() {
		return ansB;
	}

	public void setAnsB(String ansB) {
		this.ansB = ansB;
	}

	public String getAnsC() {
		return ansC;
	}

	public void setAnsC(String ansC) {
		this.ansC = ansC;
	}

	public String getAnsD() {
		return ansD;
	}

	public void setAnsD(String ansD) {
		this.ansD = ansD;
	}
	
	public String getJsonString(){
		JSONObject jsonObj = new JSONObject();
		try {
			jsonObj.put("content", content);
			jsonObj.put("type", type);
			jsonObj.put("catagory", catagory);
			if(type == 0){
				jsonObj.put("ansA", ansA);
				jsonObj.put("ansB", ansB);
				jsonObj.put("ansC", ansC);
				jsonObj.put("ansD", ansD);
				jsonObj.put("ansShort", ansShort);
			}
			else if(type == 1){
				jsonObj.put("ansShort", ansShort);
			}
			else if(type == 2){
				jsonObj.put("ansLong", ansLong);
				jsonObj.put("value", value);
			}
			return jsonObj.toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
