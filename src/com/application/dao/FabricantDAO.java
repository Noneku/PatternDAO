package com.application.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.application.model.Continent;
import com.application.model.Fabricant;
import com.application.model.Pays;

public class FabricantDAO extends DAO<Fabricant> {

	public FabricantDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Fabricant fabricant) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Fabricant read(Long id) {


		Fabricant fabricant = null;
		
		String sqlString = "SELECT ID_FABRICANT, NOM_FABRICANT FROM FABRICANT WHERE ID_FABRICANT = ?";
		
		try(PreparedStatement preparedStatement = getConnection().prepareStatement(sqlString);) {
			preparedStatement.setLong(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				fabricant = new Fabricant(resultSet.getInt(1), resultSet.getString(2));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return fabricant;
	
	}

	@Override
	public ArrayList<Fabricant> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Fabricant fabricant, String newValue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Fabricant object) {
		// TODO Auto-generated method stub
		return false;
	}

}
