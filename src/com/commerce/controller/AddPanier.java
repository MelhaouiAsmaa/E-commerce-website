package com.commerce.controller;

import java.io.IOException; 
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.commerce.model.bo.Item;
import com.commerce.model.dao.ProduitDao;

/**
 * Servlet implementation class AddPanier
 */
@WebServlet("/AddPanier")
public class AddPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPanier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		int prdid = Integer.parseInt(request.getParameter("PrdId").trim());
//		System.out.println("la quantite est: "+ request.getParameter("qte"));
//		//int qte = Integer.parseInt(request.getParameter("quantity").trim());
//		System.out.println(prdid);
//		List<Item> panier = new ArrayList<Item>();
//		ProduitDao dao = new ProduitDao();
//		
//		Produit prd = dao.getProduit(prdid);
//		Item item = new Item();
//		item.setProduit(prd);
//		//item.setQte(qte);
//		panier.add(item);
//		for(int i = 0; i<panier.size();i++ )
//		{
//			System.out.println("Id: " + panier.get(i).getProduit().getProduitId()+ ", qte: " + panier.get(i)
//			.getQte());
//		}
//		response.sendRedirect("/CommerceWeb/"); 
		String action = request.getParameter("action");
			if (action.equalsIgnoreCase("buy")) 
			{
				doGet_Buy(request, response);
			} else if (action.equalsIgnoreCase("remove")) 
			{
				doGet_Remove(request, response);	
		    }
	}
	
	protected void doGet_Remove(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		int index = isExisting(Integer.parseInt(request.getParameter("id")), cart);
		int quantity = cart.get(index).getQte();
		if(quantity == 1)
		{
			cart.remove(index);
		}
		else if(quantity>1)
		{
			cart.get(index).setQte(quantity-1);
		}
		session.setAttribute("cart", cart);
		response.sendRedirect("/CommerceWeb/cart.jsp");
	}
	
	protected void doGet_Buy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	
		ProduitDao dao = new ProduitDao();
		HttpSession session = request.getSession();
		
		if (session.getAttribute("cart") == null) {
			
			List<Item> cart = new ArrayList<Item>();
			cart.add(new Item(dao.getProduit(Integer.parseInt(request.getParameter("PrdId").trim())), 1));
			session.setAttribute("cart", cart);
		} else {
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			int index = isExisting(Integer.parseInt(request.getParameter("PrdId").trim()), cart);
			if (index == -1) {
				cart.add(new Item(dao.getProduit(Integer.parseInt(request.getParameter("PrdId").trim())), 1));
			} else {
				int quantity = cart.get(index).getQte() + 1;
				cart.get(index).setQte(quantity);
				System.out.println("quantité: " + cart.get(index).getQte());
			}
			
			session.setAttribute("cart", cart);
		}
		response.sendRedirect("/CommerceWeb/cart.jsp");
	}
	
	private int isExisting(Integer id, List<Item> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProduit().getProduitId().equals(id)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getParameter("qte");
		doGet(request, response);
	}

}
