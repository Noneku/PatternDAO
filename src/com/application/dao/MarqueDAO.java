package com.application.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.application.model.Continent;
import com.application.model.Fabricant;
import com.application.model.Marque;
import com.application.model.Pays;

public class MarqueDAO extends DAO<Marque> {

	public MarqueDAO() {}

	@Override
	public boolean create(Marque marque) {

		
		String sqlString = "INSERT INTO MARQUE (ID_MARQUE, NOM_MARQUE, ID_PAYS, ID_FABRICANT) values (?, ?, ?, ?)";
		try(PreparedStatement preparedStatement = getConnection().prepareStatement(sqlString);) {
			preparedStatement.setInt(1, marque.getId_marque() + 1);
			preparedStatement.setString(2, marque.getNom_marque());
			preparedStatement.setInt(3, marque.getPays().getId_pays());
			preparedStatement.setInt(3, marque.getFabricant().getId_fabricant());
			preparedStatement.executeUpdate();
			System.out.println("Création pays : OK");
			
			System.out.println("Votre marque est associé au pays : " + marque.getPays().getNom_pays());
			return true;
		} catch (Exception e) {
			System.out.println("Création pays : KO");
			return false;
		}

	
	}

	@Override
	public Marque read(Long id) {


		Marque marque = null;
		
		String sqlString = "SELECT ID_MARQUE, NOM_MARQUE, ID_PAYS, ID_FABRICANT FROM MARQUE WHERE ID_MARQUE = ?";
		
		try(PreparedStatement preparedStatement = getConnection().prepareStatement(sqlString);) {
			preparedStatement.setLong(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				marque = new Marque(
						resultSet.getInt(1),
						resultSet.getString(2),
						DAOFactory.paysDAO().read((long) resultSet.getInt(3)),
						DAOFactory.fabricantDAO().read((long) resultSet.getInt(4)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return marque;
	
	}

	@Override
	public ArrayList<Marque> readAll() {

		
		ResultSet rs;
		ArrayList<Marque> liste = new ArrayList<>();
		
		try {
			String sqlString = "SELECT ID_MARQUE, NOM_MARQUE, ID_PAYS, ID_FABRICANT FROM MARQUE ORDER BY ID_MARQUE";
			Statement stmt = getConnection().createStatement();
			rs = stmt.executeQuery(sqlString);
			while(rs.next() ) {
				Pays pays = DAOFactory.paysDAO().read((long) rs.getInt(3));
				Fabricant fabricant = DAOFactory.fabricantDAO().read((long) rs.getInt(4));
				
				liste.add(new Marque(rs.getInt(1), rs.getString(2), pays, fabricant));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return liste;
	}

	@Override
	public boolean delete(Marque marque) {

		try {
			String sqlString = "DELETE FROM MARQUE WHERE ID_MARQUE = ?";
			PreparedStatement preparedStatement = getConnection().prepareStatement(sqlString);
			preparedStatement.setInt(1, marque.getId_marque());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public boolean update(Marque marque, String newValue) {

		try {
			String sqlString = "UPDATE MARQUE SET NOM_MARQUE = ? WHERE ID_MARQUE = ?";
			PreparedStatement preparedStatement = getConnection().prepareStatement(sqlString);
			preparedStatement.setString(1, newValue);
			preparedStatement.setInt(2, marque.getId_marque());
			preparedStatement.executeUpdate();
			System.out.println("Element modifié");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
