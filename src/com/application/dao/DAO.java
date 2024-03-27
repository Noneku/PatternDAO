package com.application.dao;

import java.sql.Connection;
import java.util.ArrayList;

import util.MySQLConnect;

public abstract class DAO <T> {

	public Connection getConnection() {
		return MySQLConnect.getConnection();
	}
	
	public abstract boolean create(T object);
	public abstract T read(Long id);
	public abstract ArrayList<T> readAll();
	public abstract boolean update(T object, String newValue);
	public abstract boolean delete(T object);
}
