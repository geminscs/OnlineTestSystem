package com.train.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
  


import com.train.daos.IStudentDao;  
import com.train.models.Student;  
  
@Service  
public class StudentServiceImpl implements IStudentService {  
      
    @Autowired  
    private IStudentDao studentDao;  
  
    public int lookStudent() {  
        return studentDao.lookStudent();  
    }  
    /** 
     * 删除表数�? 
     * @return 
     */  
    public int deleteStudent(String account){  
        return studentDao.deleteStudent(account);  
    }  
    /** 
     * 添加数据 
     * @param user 
     */  
    public void saveStudent(Student student){  
        studentDao.saveStudent(student);;  
    }
	public Student findbyAccount(String account) {
		return studentDao.findbyAccount(account);
	}
	public void updateStudent(Student student) {
		studentDao.updateStudent(student);
	}
	public List<Student> findAll() {
		return studentDao.findAll();
	}  
}