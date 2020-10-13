package com.commerce.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil 
{
	public static SessionFactory sessionFactory;

	private HibernateUtil() {
		sessionFactory =new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}
   

    public static SessionFactory getSessionFactory() {
    	try {
    		 if (sessionFactory == null) {
    	    	   System.out.println("New Connection !!!");
    	    	   new HibernateUtil();
    			}else {
    				System.out.println("Connection !!!");
    			}
			
    	}catch(HibernateException exception){
			     System.out.println("Problem creating session factory");
			     exception.printStackTrace();
			     System.out.println("End of Trace");
    	}
       return sessionFactory;
    }

}
