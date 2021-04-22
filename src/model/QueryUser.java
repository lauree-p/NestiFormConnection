package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import controller.Connexion;
import entity.User;

public class QueryUser {
	
	private static User userConnected;
	private static Boolean emailAlreadyUsed = false;

	/**
	 * Search user by nickname
	 * @param nickname
	 * @param password
	 * @return ArrayList<User>
	 */
	public static User findOneByNickname(String nickname) {
		
		ArrayList<User> row = new ArrayList<User>();
		User user = new User();
		
		try {
			java.sql.Statement declaration = Connexion.accessDataBase.createStatement();
			String query = "SELECT * FROM user WHERE nickname='"+ nickname +"'";
			ResultSet resultat = declaration.executeQuery(query);
			while (resultat.next()) {
				user = new User(
						resultat.getInt("idUser"), 
						resultat.getString("nickname"), 
						resultat.getString("email"),
						resultat.getString("name"),
						resultat.getString("firstname"),
						resultat.getString("city"),
						resultat.getString("password")
					);
				row.add(user);
				userConnected = user;
			}

		} catch (Exception e) {
			System.err.println("Erreur lors de la recuperation");
		}
		
		return user;

	}
	
	/**
	 * Search user by nickname
	 * @param nickname
	 * @param password
	 * @return ArrayList<User>
	 */
	public static User findOneByEmail(String email) {
		
		ArrayList<User> row = new ArrayList<User>();
		User user = new User();
		
		try {
			java.sql.Statement declaration = Connexion.accessDataBase.createStatement();
			String query = "SELECT * FROM user WHERE email='"+ email +"'";
			ResultSet resultat = declaration.executeQuery(query);
			while (resultat.next()) {
				user = new User(
						resultat.getInt("idUser"), 
						resultat.getString("nickname"), 
						resultat.getString("email"),
						resultat.getString("name"),
						resultat.getString("firstname"),
						resultat.getString("city"),
						resultat.getString("password")
					);
				row.add(user);
				userConnected = user;
				emailAlreadyUsed = false;
			}

		} catch (Exception e) {
			emailAlreadyUsed = true;
			System.err.println("Erreur lors de la recuperation");
		}
		
		return user;

	}
	
	/**
	 * 
	 * @param nickname
	 * @param email
	 * @param name
	 * @param firstname
	 * @param city
	 * @param password
	 */
	public void createUser(String nickname,String email,String name,String firstname,String city,String password) {
		
		try {
			java.sql.Statement declaration = Connexion.accessDataBase.createStatement();
			String query = "INSERT INTO `user` (`nickname`, `email`, `name`, `firstname`, `city`, `password`) VALUES ('"+nickname+"','"+email+"','"+name+"','"+firstname+"','"+city+"','"+password+"')";
			declaration.executeUpdate(query);
			
			JButton btnNewButton = new JButton("OK");
			JOptionPane.showMessageDialog(btnNewButton, "Votre compte à bien était crée !");
			
		} catch (Exception e) {
			System.err.println("Erreur lors de la recuperation");
		}

	}
	
	/**
	 * 
	 * @param nickname
	 * @param email
	 * @param name
	 * @param firstname
	 * @param city
	 * @param password
	 * @return 
	 */
	public static User updateUser(String nickname,String email,String name,String firstname,String city) {
		
		User userUpdated = new User();
		
		try {
			java.sql.Statement declaration = Connexion.accessDataBase.createStatement();
			String query = "UPDATE user SET nickname = '"+nickname+"', email = '"+email+"', name = '"+name+"', firstname = '"+firstname+"', city = '"+city+"' WHERE idUser = "+userConnected.getIdUser();
			declaration.executeUpdate(query);
			JButton btnNewButton = new JButton("OK");
			JOptionPane.showMessageDialog(btnNewButton, "Votre compte à bien était Modifier !");
			userUpdated = findOneByNickname(nickname);
			
		} catch (Exception e) {
			System.err.println("Erreur lors de la recuperation");
		}
		return userUpdated;
	}

	/**
	 * @return the emailAlreadyUsed
	 */
	public static Boolean getEmailAlreadyUsed() {
		return emailAlreadyUsed;
	}

	/**
	 * @param emailAlreadyUsed the emailAlreadyUsed to set
	 */
	public static void setEmailAlreadyUsed(Boolean emailAlreadyUsed) {
		QueryUser.emailAlreadyUsed = emailAlreadyUsed;
	}
}
