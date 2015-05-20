package com.train.services;

import java.util.List;

import com.train.models.Student;;

public interface IStudentService {  
    public int lookStudent();  
    public int deleteStudent(String account);  
    public void saveStudent(Student student);  
    public Student findbyAccount(String account);
    public void updateStudent(Student student);
    public List<Student> findAll();
}  