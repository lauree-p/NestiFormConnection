package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import tool.Config;

public class Connexion {
	public static Connection accessDataBase = null;

	/**
	 * Testons la connexion
	 * 
	 * @param args
	 */

	public static void openConnection() {
		/* Parametres de connexion */

		String url = Config.getUrlbsd();
		// nesti = nom de ma bdd
		String utilisateur = Config.getUsername();
		String motDePasse = Config.getPassword();
		try {
			// on ajoute nos param�tres
			accessDataBase = DriverManager.getConnection(url, utilisateur, motDePasse);
		} catch (SQLException ex) {
			Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
		}
	}


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