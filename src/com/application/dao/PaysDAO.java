package com.application.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.application.model.Continent;
import com.application.model.Pays;

public class PaysDAO extends DAO<Pays> {

	public PaysDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Pays pays) {
		
			String sqlString = "INSERT INTO PAYS (ID_PAYS, NOM_PAYS, ID_CONTINENT) values (?, ?, ?)";
			try(PreparedStatement preparedStatement = getConnection().prepareStatement(sqlString);) {
				preparedStatement.setInt(1, pays.getId_pays() + 1);
				preparedStatement.setString(2, pays.getNom_pays());
				preparedStatement.setInt(3, pays.getContinent().getId_continent());
				preparedStatement.executeUpdate();
				System.out.println("Création pays : OK");
				
				System.out.println("Votre pays est associé au continent : " + pays.getContinent().getNom_continent() + " avec pour ID : " + pays.getContinent().getId_continent());
				return true;
			} catch (Exception e) {
				System.out.println("Création pays : KO");
				return false;
			}
}

	@Override
	public Pays read(Long id) {

		Pays pays = null;
		
		String sqlString = "SELECT ID_PAYS, NOM_PAYS, ID_CONTINENT FROM PAYS WHERE ID_PAYS = ?";
		
		try(PreparedStatement preparedStatement = getConnection().prepareStatement(sqlString);) {
			preparedStatement.setLong(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				pays = new Pays(resultSet.getInt(1), resultSet.getString(2), DAOFactory.continentDAO().read((long) resultSet.getInt(3)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pays;
	}

	@Override
	public ArrayList<Pays> readAll() {

		
		ResultSet rs;
		ArrayList<Pays> liste = new ArrayList<>();
		
		try {
			String sqlString = "SELECT ID_PAYS, NOM_PAYS, ID_CONTINENT FROM PAYS ORDER BY ID_PAYS";
			Statement stmt = getConnection().createStatement();
			rs = stmt.executeQuery(sqlString);
			while(rs.next() ) {
				Continent continent = DAOFactory.continentDAO().read((long) rs.getInt(3));
				
				liste.add(new Pays(rs.getInt(1), rs.getString(2), continent));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return liste;
	}


	@Override
	public boolean delete(Pays pays) {

		try {
			String sqlString = "DELETE FROM PAYS WHERE ID_PAYS = ?";
			PreparedStatement preparedStatement = getConnection().prepareStatement(sqlString);
			preparedStatement.setInt(1, pays.getId_pays());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public boolean update(Pays pays, String newValue) {

		try {
			String sqlString = "UPDATE PAYS SET NOM_PAYS = ? WHERE ID_PAYS = ?";
			PreparedStatement preparedStatement = getConnection().prepareStatement(sqlString);
			preparedStatement.setString(1, newValue);
			preparedStatement.setInt(2, pays.getId_pays());
			preparedStatement.executeUpdate();
			System.out.println("Element modifié");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
