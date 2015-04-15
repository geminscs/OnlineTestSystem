package com.train.daos;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.train.models.Grade;

@Repository
public class GradeDaoImpl extends BaseDao implements IGradeDao{

	public void saveGrade(Grade grade) {
		getCurrentSession().save(grade);
	}

	public void updateGrade(Grade grade) {
		getCurrentSession().update(grade);
	}

	public void deleteGrade(int id) {
		Query query = getCurrentSession().createSQLQuery("DELETE FROM grade where id = " + id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public Grade findById(int id) {
		Query query = getCurrentSession().createSQLQuery("SELECT * FROM grade where id =" +id).addEntity(Grade.class);
		List<Grade> list = query.list();
		if(list.size() == 0){
			return null;
		}
		else{
			return list.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Grade> findByStudentId(String studentId) {
		Query query = getCurrentSession().createSQLQuery("SELECT * FROM grade where student_id = '" + studentId + "'").addEntity(Grade.class);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Grade> findByTestId(int testId) {
		Query query = getCurrentSession().createSQLQuery("SELECT * FROM grade where test_id = " + testId).addEntity(Grade.class);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public Grade findByStudentIdAndTestId(String studentId, int testId) {
		Query query = getCurrentSession().createSQLQuery("SELECT * FROM grade where test_id = " + testId + " and student_id = '" + studentId + "'").addEntity(Grade.class);
		List<Grade> list = query.list();
		if(list.size() == 0){
			return null;
		}
		else{
			return list.get(0);
		}
	}
	
}
