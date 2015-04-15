package com.train.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
   

import com.train.daos.ITestDao; 
import com.train.models.Test;
  
@Service  
public class TestServiceImpl implements ITestService {  
      
    @Autowired  
    private ITestDao testDao;

	public int lookTest() {
		testDao.lookTest();
		return 0;
	}

	public int deleteTest(int id) {
		return testDao.deleteTest(id);
	}

	public void saveTest(Test test) {
		testDao.saveTest(test);
	}

	public void updateTest(Test test) {
		testDao.updateTest(test);
	}

	public Test findbyId(int id) {
		return testDao.findbyId(id);
	}

	public List<Test> findAllTests() {
		return testDao.findAllTests();
	}

	public List<Test> findAllByTime(long time) {
		return testDao.findAllByTime(time);
	}  
  
    
}