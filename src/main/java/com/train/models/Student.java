package com.train.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
	@Column(name="account")
	private String account;
	
	@Column(name="name")
	private String name;
	
	@Column(name="password")
	private String password;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Student(String account, String name, String password) {
		super();
		this.account = account;
		this.name = name;
		this.password = password;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
