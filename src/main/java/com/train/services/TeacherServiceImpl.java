package com.train.services;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
  

import com.train.daos.ITeacherDao;  
import com.train.models.Teacher;  
  
@Service  
public class TeacherServiceImpl implements ITeacherService {  
      
    @Autowired  
    private ITeacherDao teacherDao;  
  
    public int lookTeacher() {  
        return teacherDao.lookTeacher();  
    }  
    /** 
     * 删除表数�? 
     * @return 
     */  
    public int deleteTeacher(String account){  
        return teacherDao.deleteTeacher(account);  
    }  
    /** 
     * 添加数据 
     * @param user 
     */  
    public void saveTeacher(Teacher teacher){  
    	teacherDao.saveTeacher(teacher);;  
    }
	public Teacher findbyAccount(String account) {
		return teacherDao.findbyAccount(account);
	}  
}
