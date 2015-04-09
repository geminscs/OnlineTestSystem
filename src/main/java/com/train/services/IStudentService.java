package com.train.services;

import com.train.models.Student;;

public interface IStudentService {  
    public int lookStudent();  
    public int deleteStudent(String account);  
    public void saveStudent(Student student);  
    public Student findbyAccount(String account);
}  