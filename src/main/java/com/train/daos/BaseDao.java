package com.train.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDao {  
    @Autowired  
    private SessionFactory sessionFactory;  
      
    public Session getCurrentSession(){  
        return sessionFactory.getCurrentSession();  
    }  
}  