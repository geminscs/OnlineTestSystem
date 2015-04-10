package com.train.daos;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.train.daos.BaseDao;
import com.train.models.Teacher;

@Repository
public class TeacherDapImpl extends BaseDao implements ITeacherDao{
	public int lookTeacher(){
		Query query = getCurrentSession().createQuery("FROM teahcer");
		List<?>l = query.list();
		return l.size();

	}

	public int deleteTeacher(String account){
		Query query = getCurrentSession().createSQLQuery("DELETE FROM teacher where account = '"+account+"'");
		return query.executeUpdate();
	}

	public void saveTeacher(Teacher teacher){
		getCurrentSession().save(teacher);
	}

	@SuppressWarnings("unchecked")
	public Teacher findbyAccount(String account){
		Query query = getCurrentSession().createSQLQuery("SELECT * FROM teacher where account = '"+account+"'").addEntity(Teacher.class);
		List<Teacher> list = query.list();
		if(list.size() == 0){
			return null;
		}
		else{
			return list.get(0);
		}
	}
}