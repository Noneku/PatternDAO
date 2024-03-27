package com.application.model;


public class Pays {
	
	int id_pays;

	String nom_pays;
	
	Continent continent;
	
	public Pays(int id_pays, String nom_pays, Continent continent) {
		super();
		this.id_pays = id_pays;
		this.nom_pays = nom_pays;
		this.continent = continent;
	}

	public int getId_pays() {
		return id_pays;
	}

	public void setId_pays(int id_pays) {
		this.id_pays = id_pays;
	}

	public String getNom_pays() {
		return nom_pays;
	}

	public void setNom_pays(String nom_pays) {
		this.nom_pays = nom_pays;
	}

	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}
	

}
