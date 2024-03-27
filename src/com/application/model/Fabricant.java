package com.application.model;

public class Fabricant {
	
	public int getId_fabricant() {
		return id_fabricant;
	}

	public void setId_fabricant(int id_fabricant) {
		this.id_fabricant = id_fabricant;
	}

	public String getNom_fabricant() {
		return nom_fabricant;
	}

	public void setNom_fabricant(String nom_fabricant) {
		this.nom_fabricant = nom_fabricant;
	}

	int id_fabricant;
	String nom_fabricant;
	
	public Fabricant(int id_fabricant, String nom_fabricant) {
		super();
		this.id_fabricant = id_fabricant;
		this.nom_fabricant = nom_fabricant;
	}


}
