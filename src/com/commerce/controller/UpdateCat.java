package com.commerce.controller;

import java.io.IOException;
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
 * Servlet implementation class UpdateCat
 */
@WebServlet("/UpdateCat")
public class UpdateCat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int catid = Integer.parseInt(request.getParameter("CatId"));
		CategorieDao daoC = new CategorieDao();
		Categorie cat = daoC.getCategorie(catid);
		
		request.setAttribute("idcat", catid);
		request.setAttribute("nomcat", cat.getCategorieNom());
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/UpdateCat.jsp");
	    requestDispatcher.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idc = Integer.parseInt(request.getParameter("IdCateg"));
		
		CategorieDao daoC = new CategorieDao();
		Categorie cat = daoC.getCategorie(idc);
		
		cat.setCategorieNom(request.getParameter("nameCat"));
/*		cat = */daoC.saveorupdateCategorie(cat);
		
//		ProduitDao prddao = new ProduitDao();
//		List<Produit> listp = cat.getListeprds();
//		
//		for(int i =0; i<listp.size(); i++)
//		{
//			listp.get(i).setCategId(cat);
//			prddao.updateProduit(listp.get(i));
//		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminServlet");
	    requestDispatcher.forward(request, response); 
	}

}
