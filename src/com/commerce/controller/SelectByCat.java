package com.commerce.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.commerce.model.bo.Produit;
import com.commerce.model.dao.ProduitDao;

/**
 * Servlet implementation class SelectByCat
 */
@WebServlet("/SelectByCat")
public class SelectByCat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectByCat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int id = Integer.parseInt(request.getParameter("category"));
		//System.out.println("valeur dropdown : " + id);
		if(id >= 1)
		{
			ProduitDao daoP = new ProduitDao();	
			List<Produit> listprd = new ArrayList<Produit>();
			listprd = daoP.findByCategorie(id);
		    request.setAttribute("produits", listprd);
			
		             
	        String page = "/ProduitByCat.jsp";
	        RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
	        requestDispatcher.forward(request, response);  	
		}		
		else 
		{
			response.sendRedirect("/CommerceWeb/");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
