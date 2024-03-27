package com.application.main;

import java.util.List;

import com.application.dao.DAOFactory;
import com.application.model.Continent;
import com.application.model.Couleur;
import com.application.model.Marque;
import com.application.model.Pays;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
	
	List<Pays> allPays = DAOFactory.paysDAO().readAll();
	int id = 0;
	
	for (Pays continent : allPays) {
		id++;
		
    }

	Continent continent = DAOFactory.continentDAO().read(6L);
	
	Pays nouveauPays = new Pays(id, "Boulial", continent);
	
	
	
	Marque marque = DAOFactory.marqueDAO().read(12L);
	
	//System.out.println(marque.toString());
	
	//DAOFactory.continentDAO().update(nouveauPays, "Pliakov", );
	
	DAOFactory.marqueDAO().update(marque, "Leffant");
	
	}
	
}
