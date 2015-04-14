package com.train.daos;

import java.util.List;

import com.train.models.Test;

public interface ITestDao{
	public int lookTest();

	public int deleteTest(int id);

	public void saveTest(Test test);
	
	public void updateTest(Test test);

	public Test findbyId(int id);
	
	public List<Test> findAllTests();
}