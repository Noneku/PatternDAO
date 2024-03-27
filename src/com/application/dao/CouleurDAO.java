package com.application.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.application.model.Couleur;

public class CouleurDAO extends DAO<Couleur> {

	public CouleurDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Couleur couleur) {
		String sqlString = "INSERT INTO COULEUR (ID_COULEUR, NOM_COULEUR) values (?, ?)";
		try(PreparedStatement preparedStatement = getConnection().prepareStatement(sqlString);) {
			preparedStatement.setInt(1, couleur.getId_couleur() + 1);
			preparedStatement.setString(2, couleur.getNom_couleur());
			preparedStatement.executeUpdate();
			System.out.println("Création Couleur : OK");
			return true;
		} catch (Exception e) {
			System.out.println("Création Couleur : KO");
			return false;
		}
	}

	@Override
	public Couleur read(Long id) {
		Couleur couleur = null;
		String sqlString = "SELECT ID_COULEUR, NOM_COULEUR FROM COULEUR WHERE ID_COULEUR = ?";
		
		try(PreparedStatement preparedStatement = getConnection().prepareStatement(sqlString);) {
			preparedStatement.setLong(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				couleur = new Couleur(resultSet.getInt(1), resultSet.getString(2));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return couleur;
	}

	@Override
	public ArrayList<Couleur> readAll() {
		
		ResultSet rs;
		ArrayList<Couleur> liste = new ArrayList<>();
		
		try {
			String sqlString = "SELECT ID_COULEUR, NOM_COULEUR FROM COULEUR ORDER BY ID_COULEUR";
			Statement stmt = getConnection().createStatement();
			rs = stmt.executeQuery(sqlString);
			while(rs.next() ) {
				liste.add(new Couleur(rs.getInt(1), rs.getString(2)));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return liste;
	}

	@Override
	public boolean update(Couleur couleur, String newCouleur) {
		try {
			String sqlString = "UPDATE COULEUR SET NOM_COULEUR = ? WHERE ID_COULEUR = ?";
			PreparedStatement preparedStatement = getConnection().prepareStatement(sqlString);
			preparedStatement.setString(1, newCouleur);
			preparedStatement.setInt(2, couleur.getId_couleur());
			preparedStatement.executeUpdate();
			System.out.println("Element modifié");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Couleur couleur) {
		try {
			String sqlString = "DELETE FROM COULEUR WHERE ID_COULEUR = ?";
			PreparedStatement preparedStatement = getConnection().prepareStatement(sqlString);
			preparedStatement.setInt(1, couleur.getId_couleur());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

}
