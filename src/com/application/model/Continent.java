package com.application.model;

public class Continent {
	
	
	public int getId_continent() {
		return id_continent;
	}

	public void setId_continent(int id_continent) {
		this.id_continent = id_continent;
	}

	public String getNom_continent() {
		return nom_continent;
	}

	public void setNom_continent(String nom_continent) {
		this.nom_continent = nom_continent;
	}

	int id_continent;
	String nom_continent;

	public Continent(int id_continent, String nom_continent) {
		this.id_continent = id_continent;
		this.nom_continent = nom_continent;
	}

}
