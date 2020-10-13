package com.commerce.model.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.commerce.model.bo.Categorie;
import com.commerce.util.HibernateUtil;

public class CategorieDao {
	
	public Categorie saveorupdateCategorie(Categorie cat)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.saveOrUpdate(cat);
        Transaction transaction = session.beginTransaction();
        transaction.commit();
        session.close();
        
        return cat;
	}
	
//	public Categorie updateCategorie(Categorie cat)
//	{
//		Session session=HibernateUtil.getSessionFactory().openSession();
//		Transaction tx = null;
//        try {
//            tx = session.beginTransaction();        
//            session.update(cat);
//            tx.commit();
//        } catch (HibernateException e) {
//            tx.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return cat;
//		
//	}
	
	public void deleteCategorie(int catId)
	{
		Session S = HibernateUtil.getSessionFactory().openSession();
		
		Categorie P = (Categorie)S.get(Categorie.class, catId);
		S.delete(P);
		Transaction tx=S.beginTransaction();
		tx.commit();
		S.close();
	}
	
	public Categorie getCategorie(int catId)
	 {
	      
			Transaction tx = null;
	        Categorie cat = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        cat = (Categorie) session.get(Categorie.class, catId);   
	        tx = session.beginTransaction();
	        tx.commit();
	        session.close();
	        
	        return cat;
	 }
	 
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Categorie> getCategories()
	    {
		 	Session S = HibernateUtil.getSessionFactory().openSession();	
			Query query = S.createQuery("from Categorie"); 	
			List<Categorie> cats = query.list();
			Transaction tx=S.beginTransaction();
			tx.commit();
			S.close();
			
			return cats;
	    }


}
