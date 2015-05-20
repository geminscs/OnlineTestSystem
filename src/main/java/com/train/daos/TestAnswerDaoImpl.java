package com.train.daos;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.train.models.TestAnswer;
import com.train.models.TestQuestion;

@Repository
public class TestAnswerDaoImpl extends BaseDao implements ITestAnswerDao{

	public void saveTestAnswer(TestAnswer testAnswer) {
		getCurrentSession().save(testAnswer);
	}

	public void updataTestAnswer(TestAnswer testAnswer) {
		getCurrentSession().update(testAnswer);
	}

	public void delteTestAnswer(int id) {
		Query query = getCurrentSession().createSQLQuery("DELETE FROM test_answer where id = " + id);
		query.executeUpdate();
	}

	public void deleteTestAnswerByTestId(int testId) {
		Query query = getCurrentSession().createSQLQuery("DELETE FROM test_answer where test_id = " + testId);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public TestAnswer findById(int id) {
		Query query = getCurrentSession().createSQLQuery("SELECT * FROM test_answer where id = "+id).addEntity(TestAnswer.class);
		List<TestAnswer> list = query.list();
		if(list.size() == 0){
			return null;
		}
		else{
			return list.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	public List<TestAnswer> findByTestIdAndStudentId(int testId, String studetId) {
		Query query = getCurrentSession().createSQLQuery("SELECT * FROM test_answer where test_id = " + testId + " and student_id = '" + studetId + "'").addEntity(TestAnswer.class);
		return query.list();
	}

}
