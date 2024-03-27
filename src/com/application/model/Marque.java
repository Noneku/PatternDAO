package com.application.model;

public class Marque {
	
	public int getId_marque() {
		return id_marque;
	}

	public void setId_marque(int id_marque) {
		this.id_marque = id_marque;
	}

	public String getNom_marque() {
		return nom_marque;
	}

	public void setNom_marque(String nom_marque) {
		this.nom_marque = nom_marque;
	}

	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}

	public Fabricant getFabricant() {
		return fabricant;
	}

	public void setFabricant(Fabricant fabricant) {
		this.fabricant = fabricant;
	}

	@Override
	public String toString() {
		return "Marque [id_marque=" + id_marque + ", nom_marque=" + nom_marque + ", pays=" + pays.getId_pays() + ", fabricant="
				+ fabricant.getId_fabricant() + "]";
	}

	int id_marque;
	String nom_marque;
	Pays pays;
	Fabricant fabricant;
	
	public Marque(int id_marque, String nom_marque, Pays pays, Fabricant fabricant) {
		this.id_marque = id_marque;
		this.nom_marque = nom_marque;
		this.pays = pays;
		this.fabricant = fabricant;
	}



}
