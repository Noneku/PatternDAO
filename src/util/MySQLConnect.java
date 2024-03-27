package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnect {

	private MySQLConnect() {
	}
	
	private static Connection connection;
	private static final String URL = "jdbc:mysql://localhost:3308/SDBM";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // Méthode pour établir une connexion à la base de données
    public static Connection getConnection() {
    	if (connection == null) {
    		
    		try {
    			connection = DriverManager.getConnection(URL, USER, PASSWORD);
    			System.out.println("Vous êtes connecté");
    		}catch(
    				SQLException sqlException) {
    			sqlException.printStackTrace();
    			System.out.println("Connection échoué");
    		}
    		
    	}
        return connection;
    }

    // Méthode pour fermer la connexion à la base de données
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
