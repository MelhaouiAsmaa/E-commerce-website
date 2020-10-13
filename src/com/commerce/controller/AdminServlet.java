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

import com.commerce.model.bo.Categorie;
import com.commerce.model.bo.Produit;
import com.commerce.model.dao.CategorieDao;
import com.commerce.model.dao.ProduitDao;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProduitDao daoPrd = new ProduitDao();
		List<Produit> listePrd = daoPrd.getProduits();
		request.setAttribute("Produits", listePrd);
		
//		for(int i =0; i <listePrd.size();i++)
//		{
//			System.out.println("Produit " + i +": "+listePrd.get(i).getProdNom());
//		}
		
		CategorieDao daoCat = new CategorieDao();
		List<Categorie> listeCat = daoCat.getCategories();
		request.setAttribute("Categories", listeCat);
		
//		for(int i =0; i <listeCat.size();i++)
//		{
//			System.out.println("Categorie " + i +": "+listeCat.get(i).getCategorieNom());
//		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/AdminArea.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
