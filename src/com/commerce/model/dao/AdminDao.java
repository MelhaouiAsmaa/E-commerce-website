package com.commerce.model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.commerce.model.bo.Admin;
import com.commerce.util.HibernateUtil;
public class AdminDao {
	
public void saveAdmin(Admin user) {
        
    	SessionFactory sf = HibernateUtil.getSessionFactory();
		System.out.println("creation sessionFactory");
		Session s =sf.openSession();
		System.out.println("Creation session");
		Transaction tx = s.beginTransaction();
		s.save(user);
		tx.commit();
		s.close();
    }

	public boolean validate(String userName, String password) {

	    Admin user = null;
	    
	    SessionFactory sf = HibernateUtil.getSessionFactory();
		System.out.println("creation sessionFactory");
		Session s =sf.openSession();
		System.out.println("Creation session");
		Transaction tx = s.beginTransaction();
	    
	        // get an user object
	        user = (Admin) s.createQuery("FROM Admin U WHERE U.login = :login").setParameter("login", userName)
	            .uniqueResult();
	
	        if (user != null && user.getPasswd().equals(password)) {
	            return true;
	        }
	        // commit transaction
	        tx.commit();
			s.close();
	    return false;
}


}
