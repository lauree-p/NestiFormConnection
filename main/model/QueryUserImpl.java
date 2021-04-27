package model;

import java.sql.ResultSet;
import java.util.ArrayList;

import entity.User;

public class QueryUserImpl implements QueryUser {

	/**
	 * Find User by nickname
	 * 
	 * @param nickname
	 * @param password
	 * @return ArrayList<User>
	 */
	@Override
	public User findOneByNickname(String nickname) {

		ArrayList<User> row = null;
		User user = null;

		try {
			Connexion.openConnection();
			java.sql.Statement declaration = Connexion.accessDataBase.createStatement();
			String query = "SELECT * FROM user WHERE nickname='" + nickname + "'";
			ResultSet resultat = declaration.executeQuery(query);
			row = new ArrayList<User>();
			while (resultat.next()) {
				user = new User(resultat.getInt("idUser"), resultat.getString("nickname"), resultat.getString("email"),
						resultat.getString("name"), resultat.getString("firstname"), resultat.getString("city"),
						resultat.getString("password"));
				row.add(user);
			}

		} catch (Exception e) {
			System.err.println("Erreur lors de la recuperation,User not findByNickname");
		}

		return user;

	}

	/**
	 * Find User by email
	 * 
	 * @param nickname
	 * @param password
	 * @return ArrayList<User>
	 */
	@Override
	public User findOneByEmail(String email) {

		ArrayList<User> row = null;
		User user = null;

		try {
			Connexion.openConnection();
			java.sql.Statement declaration = Connexion.accessDataBase.createStatement();
			String query = "SELECT * FROM user WHERE email='" + email + "'";
			ResultSet resultat = declaration.executeQuery(query);
			row = new ArrayList<User>();
			while (resultat.next()) {
				user = new User(resultat.getInt("idUser"), resultat.getString("nickname"), resultat.getString("email"),
						resultat.getString("name"), resultat.getString("firstname"), resultat.getString("city"),
						resultat.getString("password"));
				row.add(user);
			}

		} catch (Exception e) {
			System.err.println("Erreur lors de la recuperation, User not findByEmail");
		}

		return user;

	}
	
	/**
	 * Find User by email
	 * 
	 * @param nickname
	 * @param password
	 * @return ArrayList<User>
	 */
	@Override
	public User findOneById(int idUser) {

		ArrayList<User> row = null;
		User user = null;

		try {
			Connexion.openConnection();
			java.sql.Statement declaration = Connexion.accessDataBase.createStatement();
			String query = "SELECT * FROM user WHERE idUser='" + idUser + "'";
			ResultSet resultat = declaration.executeQuery(query);
			row = new ArrayList<User>();
			while (resultat.next()) {
				user = new User(resultat.getInt("idUser"), resultat.getString("nickname"), resultat.getString("email"),
						resultat.getString("name"), resultat.getString("firstname"), resultat.getString("city"),
						resultat.getString("password"));
				row.add(user);
			}

		} catch (Exception e) {
			System.err.println("Erreur lors de la recuperation, User not findByEmail");
		}

		return user;

	}

	/**
	 * Create User
	 * 
	 * @param nickname
	 * @param email
	 * @param name
	 * @param firstname
	 * @param city
	 * @param password
	 */
	@Override
	public User createUser(String nickname, String email, String name, String firstname, String city, String password) {

		User userCreate = null;
		
		try {
			Connexion.openConnection();
			java.sql.Statement declaration = Connexion.accessDataBase.createStatement();
			String query = "INSERT INTO `user` (`nickname`, `email`, `name`, `firstname`, `city`, `password`) VALUES ('"
					+ nickname + "','" + email + "','" + name + "','" + firstname + "','" + city + "','" + password
					+ "')";
			declaration.executeUpdate(query);
			userCreate = findOneByEmail(email);
		} catch (Exception e) {
			System.err.println("Erreur lors de la recuperation, User not create");
		}
		return userCreate;
	}

	/**
	 * Update User
	 * 
	 * @param userToUpdate
	 * @param nickname
	 * @param email
	 * @param name
	 * @param firstname
	 * @param city
	 * @param password
	 * @return User userToUpdate
	 */
	@Override
	public User updateUser(User userToUpdate,String nickname, String email, String name, String firstname, String city) {
		try {
			Connexion.openConnection();
			java.sql.Statement declaration = Connexion.accessDataBase.createStatement();
			String query = "UPDATE user SET nickname = '" + nickname + "', email = '" + email + "', name = '" + name
					+ "', firstname = '" + firstname + "', city = '" + city + "' WHERE email = \""+ userToUpdate.getEmail() +"\"";
			declaration.executeUpdate(query);
			//JButton btnNewButton = new JButton("OK");
			//JOptionPane.showMessageDialog(btnNewButton, "Votre compte à bien était Modifier !");

		} catch (Exception e) {
			System.err.println("Erreur lors de la recuperation, User not update");
		}
		return userToUpdate;
	}

	/**
	 * Delete User by email
	 * 
	 * @param email
	 */
	@Override
	public void deleteUserByEmail(String email) {
		try {
			Connexion.openConnection();
			java.sql.Statement declaration = Connexion.accessDataBase.createStatement();
			String query = "DELETE FROM `user` WHERE `user`.`email` = \"" + email + "\"";
			declaration.executeUpdate(query);

		} catch (Exception e) {
			System.err.println("Erreur lors de la recuperation, User not delete");
		}
	}
}
