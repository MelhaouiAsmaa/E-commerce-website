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
 * Servlet implementation class AddProduct
 */
@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CategorieDao catDao = new CategorieDao();
		List<Categorie> listCategory = catDao.getCategories();
        request.setAttribute("listCategory", listCategory);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("AddPrd.jsp");
	    requestDispatcher.forward(request, response); 
		//response.sendRedirect("AddPrd.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProduitDao daoP = new ProduitDao();
		Produit pd = new Produit();
		pd.setProdNom(request.getParameter("name"));
		pd.setDescription(request.getParameter("descr"));
		pd.setImage(request.getParameter("img"));
		pd.setPrix(Float.parseFloat(request.getParameter("price")));
		
		
		
		int id = Integer.parseInt(request.getParameter("category"));
		if(id>=1)
		{
			CategorieDao catdao = new CategorieDao();
			Categorie ct = catdao.getCategorie(id);
			pd.setCategId(ct);
		}		
		
		daoP.saveProduct(pd);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminServlet");
	    requestDispatcher.forward(request, response); 
	}

}
