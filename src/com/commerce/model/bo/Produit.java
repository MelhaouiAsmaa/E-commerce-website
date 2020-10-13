package com.commerce.model.bo;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Produit {
	
	@Id
    @Column(name="Produit_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ProduitId;
	
	@Column(name = "Produit_nom")
	private String ProdNom;
	
	private float prix;
	private String description;
	private String image; 
	
	@ManyToOne
	@JoinColumn(name = "categorie_Id")
	private Categorie categId;
	
	
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Produit(int produitId, String prodNom, float prix, String description, String image, Categorie categId) {
		super();
		ProduitId = produitId;
		ProdNom = prodNom;
		this.prix = prix;
		this.description = description;
		this.image = image;
		this.categId = categId;
		
	}


	public Integer getProduitId() {
		return ProduitId;
	}

	public void setProduitId(Integer produitId) {
		ProduitId = produitId;
	}

	public String getProdNom() {
		return ProdNom;
	}

	public void setProdNom(String prodNom) {
		ProdNom = prodNom;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Categorie getCategId() {
		return categId;
	}

	public void setCategId(Categorie categId) {
		this.categId = categId;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}


	@Override
	public String toString() {
		return "Produit [ProduitId=" + ProduitId + ", ProdNom=" + ProdNom + ", prix=" + prix + ", description="
				+ description + ", categId=" + categId + "]";
	}

	
	

}
