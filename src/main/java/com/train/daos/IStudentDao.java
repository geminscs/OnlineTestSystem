package com.train.daos;

import java.util.List;

import com.train.models.Student;

public interface IStudentDao {  
    /** 
     * 查看条数 
     * @return 
     */  
    public int lookStudent();  
      
    /** 
     * 删除表数�? 
     * @return 
     */  
    public int deleteStudent(String account);  
      
    /** 
     * 添加数据 
     * @param user 
     */  
    public void saveStudent(Student student);
    
    public Student findbyAccount(String account);
}  