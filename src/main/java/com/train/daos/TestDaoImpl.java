package com.train.daos;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.train.daos.BaseDao;
import com.train.models.Test;

@Repository
public class TestDaoImpl extends BaseDao implements ITestDao{
	public int lookTest(){
		Query query = getCurrentSession().createQuery("FROM Test");
		List<?>l = query.list();
		return l.size();

	}

	public int deleteTest(int id){
		Query query = getCurrentSession().createSQLQuery("DELETE FROM test where id = " + id);
		return query.executeUpdate();
	}

	public void saveTest(Test test){
		getCurrentSession().save(test);
	}

	@SuppressWarnings("unchecked")
	public Test findbyId(int id){
		Query query = getCurrentSession().createSQLQuery("SELECT * FROM test where id =" +id).addEntity(Test.class);
		List<Test> list = query.list();
		if(list.size() == 0){
			return null;
		}
		else{
			return list.get(0);
		}
	}

	public void updateTest(Test test) {
		getCurrentSession().update(test);
	}

	@SuppressWarnings("unchecked")
	public List<Test> findAllTests() {
		Query query = getCurrentSession().createQuery("FROM Test");
		List<Test> list = query.list();
		return list;
	}
}