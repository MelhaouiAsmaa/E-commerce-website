package com.commerce.model.dao;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.commerce.model.bo.Produit;
import com.commerce.util.HibernateUtil;

public class ProduitDao {
	
	 public Produit saveProduct(Produit prd)
	    {
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction transaction = null;
	        try {
	            transaction = session.beginTransaction();
	            session.save(prd);
	            transaction.commit();
	        } catch (HibernateException e) {
	            transaction.rollback();
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	        return prd;
	    }
	 
	 public Produit updateProduit(Produit cat)
		{
			Session s=HibernateUtil.getSessionFactory().openSession();
			s.update(cat);
			Transaction tx=s.beginTransaction();
			tx.commit();
			s.close();
			
			return cat;
		}
		
		public void deleteProduit(int prdId)
		{
			Session S = HibernateUtil.getSessionFactory().openSession();
			
			Produit P = (Produit)S.get(Produit.class, prdId);
			S.delete(P);
			Transaction tx=S.beginTransaction();
			tx.commit();
			S.close();
		}
	 
	 public Produit getProduit(int prdId)
	 {
	        System.out.println("succeeeeeeeeeess");
		 Transaction tx = null;
	        Produit C = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        C  = (Produit) session.get(Produit.class, prdId);   
	        tx = session.beginTransaction();
	        tx.commit();
	        System.out.println("success");
	        return C;
	 }
	 
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Produit> getProduits()
	    {
		 Session S = HibernateUtil.getSessionFactory().openSession();	
			Query query = S.createQuery("from Produit"); 	
			List<Produit> prds = query.list();
			Transaction tx=S.beginTransaction();
			tx.commit();
			S.close();
			
			return prds;
	    }
 
	 public List<Produit> findByCategorie(int id)
	 {
		 Session S = HibernateUtil.getSessionFactory().openSession();	
			Query query = S.createQuery("from Produit where categorie_Id = "+id); 	
			List<Produit> prds = query.list();
			Transaction tx=S.beginTransaction();
			tx.commit();
			S.close();
			
			return prds;
	 }
	
}
