package com.commerce.model.bo;


public class Item {
	

	private Produit produit;
	private int qte;
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Item(Produit produit, int qte) {
		super();
		this.produit = produit;
		this.qte = qte;
	}
	
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}

	@Override
	public String toString() {
		return "Item [produit=" + produit + ", qte=" + qte + "]";
	}
	
	
	
}
