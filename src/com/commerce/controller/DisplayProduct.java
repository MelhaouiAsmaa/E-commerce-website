package com.commerce.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.commerce.model.bo.Categorie;
import com.commerce.model.bo.Produit;
import com.commerce.model.dao.CategorieDao;
import com.commerce.model.dao.ProduitDao;

/**
 * Servlet implementation class DisplayProduct
 */
@WebServlet(name = "DisplayProduct", urlPatterns = { "/DisplayProduct" })
public class DisplayProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ProduitDao daoP;
		List<Produit> listprd;
		String rep = request.getParameter("category");
		CategorieDao catDao = new CategorieDao();
		List<Categorie> listCategory = catDao.getCategories();
        request.setAttribute("listCategory", listCategory);
		if(rep==null)
		{        
			daoP = new ProduitDao();
			listprd = new ArrayList<Produit>();
			listprd = daoP.getProduits();

		    request.setAttribute("produits", listprd);					             	  
		}
		
		else
		{
			int id = Integer.parseInt(request.getParameter("category"));
			//System.out.println("valeur dropdown : " + id);
			if(id >= 1)
			{
				daoP = new ProduitDao();	
				listprd = new ArrayList<Produit>();
				listprd = daoP.findByCategorie(id);
			    request.setAttribute("produits", listprd);	
			}		
		}
		 				
		 String page = "/HomePage.jsp";
	     RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
	     requestDispatcher.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
