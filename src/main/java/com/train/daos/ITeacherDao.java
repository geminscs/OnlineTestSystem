package com.train.daos;

import java.util.List;

import com.train.models.Teacher;

public interface ITeacherDao{
	public int lookTeacher();

	public int deleteTeacher(String account);

	public void saveTeacher(Teacher teahcer);

	public Teacher findbyAccount(String account);
}