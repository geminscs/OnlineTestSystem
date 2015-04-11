package com.train.daos;

import java.util.List;  

import org.hibernate.Query;  
import org.springframework.stereotype.Repository;  
  


import com.train.daos.BaseDao;  
import com.train.models.Student;  
  
@Repository  
public class StudentDaoImpl  extends BaseDao implements IStudentDao{  
      
    /** 
     * 查询个数 
     */  
    public int lookStudent(){  
        //Query query = getCurrentSession().createSQLQuery("SELECT COUNT(*) FROM t_user");  
        Query query = getCurrentSession().createQuery("FROM student");  
        List<?> l = query.list();  
        return l.size();  
    }  
      
    /** 
     * 删除表数�? 
     * @return 
     */  
    public int deleteStudent(String account){  
        Query query = getCurrentSession().createSQLQuery("DELETE  FROM student where account = '"+account+"'");  
        return query.executeUpdate();  
    }  
      
    /** 
     * 添加数据 
     * @param user 
     */  
    public void saveStudent(Student student){  
        getCurrentSession().save(student);  
    }

	@SuppressWarnings("unchecked")
	public Student findbyAccount(String account) {
		Query query = getCurrentSession().createSQLQuery("SELECT * FROM student where account = '"+account+"'").addEntity(Student.class);
		List<Student> list = query.list();
		if(list.size() == 0){
			return null;
		}
		else{
			return list.get(0);
		}
	}

	public void updateStudent(Student student) {
		getCurrentSession().update(student);
	}  
} 
