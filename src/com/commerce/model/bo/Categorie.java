package com.commerce.model.bo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Categorie {
	
	@Id
    @Column(name="categorie_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CateogrieId;
	
	@Column(name = "categorie_nom")
	private String CategorieNom;
	
	@OneToMany(mappedBy = "categId")
	private List<Produit> listeprds;
	
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Categorie(int cateogrieId, String categorieNom) {
		super();
		CateogrieId = cateogrieId;
		CategorieNom = categorieNom;
	}
	
	public int getCateogrieId() {
		return CateogrieId;
	}
	public void setCateogrieId(int cateogrieId) {
		CateogrieId = cateogrieId;
	}
	public String getCategorieNom() {
		return CategorieNom;
	}
	public void setCategorieNom(String categorieNom) {
		CategorieNom = categorieNom;
	}

	public List<Produit> getListeprds() {
		return listeprds;
	}

	public void setListeprds(List<Produit> listeprds) {
		this.listeprds = listeprds;
	}
	
	
	

}
