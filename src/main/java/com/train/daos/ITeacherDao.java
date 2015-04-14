package com.train.daos;

import com.train.models.Teacher;

public interface ITeacherDao{
	public int lookTeacher();

	public int deleteTeacher(String account);

	public void saveTeacher(Teacher teahcer);
	
	public void updateTeacher(Teacher teacher);

	public Teacher findbyAccount(String account);
}