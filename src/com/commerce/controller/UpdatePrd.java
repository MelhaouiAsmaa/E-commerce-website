package com.commerce.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.commerce.model.bo.Produit;
import com.commerce.model.dao.ProduitDao;

/**
 * Servlet implementation class UpdatePrd
 */
@WebServlet("/UpdatePrd")
public class UpdatePrd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePrd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("Get method");
		int prdid = 0;		
		prdid = Integer.parseInt(request.getParameter("PrdId").trim());
					
		System.out.println("prdid = "+prdid);
	
		ProduitDao daoP = new ProduitDao();
		Produit pd = daoP.getProduit(prdid);
		
		request.setAttribute("Id", prdid);
		System.out.println(pd);
			
			request.setAttribute("nom", pd.getProdNom());
			request.setAttribute("desc",pd.getDescription());
			request.setAttribute("image", pd.getImage());
			request.setAttribute("prix", pd.getPrix());
		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/UpdatePrd.jsp");
	     requestDispatcher.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post method");
		int prdid = Integer.parseInt(request.getParameter("Id").trim());
		System.out.println("doPost id product is :"+prdid);
		ProduitDao daoP = new ProduitDao();
		Produit pd = daoP.getProduit(prdid);
		pd.setProdNom(request.getParameter("name"));
		pd.setDescription(request.getParameter("descr"));
		pd.setImage(request.getParameter("img"));
		pd.setPrix(Float.parseFloat(request.getParameter("price")));
		daoP.updateProduit(pd);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminServlet");
	    requestDispatcher.forward(request, response); 
		
	}
	

}
