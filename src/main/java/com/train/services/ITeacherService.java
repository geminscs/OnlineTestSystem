package com.train.services;

import com.train.models.Teacher;;

public interface ITeacherService {  
    public int lookTeacher();  
    public int deleteTeacher(String account);  
    public void saveTeacher(Teacher teacher);  
    public Teacher findbyAccount(String account);
}  
