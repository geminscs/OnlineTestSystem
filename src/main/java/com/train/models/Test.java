package com.train.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="test")
public class Test {
	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;
	
	@Column(name="start_time")
	private long startTime;
	
	@Column(name="end_time")
	private long endTime;
	
	@Column(name="duration")
	private int duration;

	public Test(Integer id, long startTime, long endTime, int duration) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.duration = duration;
	}

	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
}
