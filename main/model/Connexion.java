package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import tool.Config;

public class Connexion {

	static Connection accessDataBase = null;

	/**
	 * Open connection with the data base
	 */
	public static void openConnection() {
		// Parameters connection
		String urlBsd = Config.getUrlbsd();
		String userBsd = Config.getUsername();
		String passwordBsd = Config.getPassword();
		try {
			// Add parameters
			accessDataBase = DriverManager.getConnection(urlBsd, userBsd, passwordBsd);
		} catch (SQLException ex) {
			Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * Close connection with the data base
	 */
	public static void closeConnection() {
		if (accessDataBase != null) {
			try {
				accessDataBase.close();
				System.out.println("Close connection");
			} catch (SQLException e) {
				System.err.println("Erreur fermreture: " + e.getMessage());
			}
		}
	}
}