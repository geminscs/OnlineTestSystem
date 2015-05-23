package com.train.daos;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.train.models.Question;

@Repository
public class QuestionDaoImpl extends BaseDao implements IQuestionDao {

	public void saveQuestion(Question qustion) {
		getCurrentSession().save(qustion);
	}

	public void updateQuestion(Question question) {
		getCurrentSession().update(question);
	}

	public void deleteQuestion(int id) {
		Query query = getCurrentSession().createSQLQuery("DELETE FROM question where id = " + id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public Question findById(int id) {
		Query query = getCurrentSession().createSQLQuery("SELECT * FROM question where id = "+id).addEntity(Question.class);
		List<Question> list = query.list();
		if(list.size() == 0){
			return null;
		}
		else{
			return list.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Question> findByCatagoryAndType(String catagory, int type) {
		Query query = getCurrentSession().createSQLQuery("SELECT * FROM question where type = " + type + " and catagory like '%" + catagory + "%'").addEntity(Question.class);
		List<Question> list = query.list();
		return list;
	}

}
