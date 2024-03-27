package com.application.dao;

import com.application.model.Article;
import com.application.model.Continent;
import com.application.model.Couleur;
import com.application.model.Fabricant;
import com.application.model.Marque;
import com.application.model.Pays;

public class DAOFactory {

	public static DAO<Couleur> couleurDAO() {
		return new CouleurDAO();
	}
	
	public static DAO<Article> articleDAO() {
		return new ArticleDAO();
	}
	
	public static DAO<Marque> marqueDAO() {
		return new MarqueDAO();
	}
	
	public static DAO<Pays> paysDAO() {
		return new PaysDAO();
	}
	public static DAO<Continent> continentDAO() {
		return new ContinentDAO();
	}
	public static DAO<Fabricant> fabricantDAO() {
		return new FabricantDAO();
	}

}
