package com.train.daos;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.train.models.TestQuestion;

@Repository
public class TestQuestionDaoImpl extends BaseDao implements ITestQuestionDao{

	public void saveTestQuestion(TestQuestion testQustion) {
		getCurrentSession().save(testQustion);
	}

	public void updataTestQuestion(TestQuestion testQuestion) {
		getCurrentSession().update(testQuestion);
	}

	public void delteTestQuestion(int id) {
		Query query = getCurrentSession().createSQLQuery("DELETE FROM test_question where id = " + id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public TestQuestion findById(int id) {
		Query query = getCurrentSession().createSQLQuery("SELECT * FROM test_question where id = "+id).addEntity(TestQuestion.class);
		List<TestQuestion> list = query.list();
		if(list.size() == 0){
			return null;
		}
		else{
			return list.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	public List<TestQuestion> findByTestId(int testId) {
		Query query = getCurrentSession().createSQLQuery("SELECT * FROM test_question where test_id = " + testId).addEntity(TestQuestion.class);
		return query.list();
	}

}
