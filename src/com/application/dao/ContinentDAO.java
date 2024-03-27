package com.application.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.application.model.Continent;

public class ContinentDAO extends DAO<Continent> {

	public ContinentDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Continent continent) {
		String sqlString = "INSERT INTO CONTINENT (ID_CONTINENT, NOM_CONTINENT) values (?, ?)";
		try(PreparedStatement preparedStatement = getConnection().prepareStatement(sqlString);) {
			preparedStatement.setInt(1, continent.getId_continent() + 1);
			preparedStatement.setString(2, continent.getNom_continent());
			preparedStatement.executeUpdate();
			System.out.println("Création Continent : OK");
			return true;
		} catch (Exception e) {
			System.out.println("Création Continent : KO");
			return false;
		}
	}

	@Override
	public Continent read(Long id) {

		Continent continent = null;
		String sqlString = "SELECT ID_CONTINENT, NOM_CONTINENT FROM CONTINENT WHERE ID_CONTINENT = ?";
		
		try(PreparedStatement preparedStatement = getConnection().prepareStatement(sqlString);) {
			preparedStatement.setLong(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				continent = new Continent(resultSet.getInt(1), resultSet.getString(2));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return continent;
	}

	@Override
	public ArrayList<Continent> readAll() {

		
		ResultSet rs;
		ArrayList<Continent> liste = new ArrayList<>();
		
		try {
			String sqlString = "SELECT ID_CONTINENT, NOM_CONTINENT FROM CONTINENT ORDER BY ID_CONTINENT";
			Statement stmt = getConnection().createStatement();
			rs = stmt.executeQuery(sqlString);
			while(rs.next() ) {
				liste.add(new Continent(rs.getInt(1), rs.getString(2)));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return liste;
	}

	@Override
	public boolean delete(Continent continent) {

		try {
			String sqlString = "DELETE FROM CONTINENT WHERE ID_CONTINENT = ?";
			PreparedStatement preparedStatement = getConnection().prepareStatement(sqlString);
			preparedStatement.setInt(1, continent.getId_continent());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public boolean update(Continent continent, String newValue) {

		try {
			String sqlString = "UPDATE CONTINENT SET NOM_CONTINENT = ? WHERE ID_CONTINENT = ?";
			PreparedStatement preparedStatement = getConnection().prepareStatement(sqlString);
			preparedStatement.setString(1, newValue);
			preparedStatement.setInt(2, continent.getId_continent());
			preparedStatement.executeUpdate();
			System.out.println("Element modifié");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
