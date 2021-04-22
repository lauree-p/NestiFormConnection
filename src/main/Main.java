package main;
import java.awt.EventQueue;

import controller.Connexion;
import view.FormLogin;
import view.FormRegistration;

public class Main {
	
	private static FormLogin formLogin;
	private static FormRegistration formSubscribe;

	
	public static void main(String[] args) {
		
		// Connection to the Database
		Connexion.openConnection();
		//Connexion.testConnection();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formLogin = new FormLogin();
					formSubscribe = new FormRegistration();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		//MyConnexion.closeConnection();
	}
	
	// Getters & Setters

	/**
	 * @return the formLogin
	 */
	public static FormLogin getFormLogin() {
		return formLogin;
	}

	/**
	 * @param formLogin the formLogin to set
	 */
	public static void setFormLogin(FormLogin formLogin) {
		Main.formLogin = formLogin;
	}

	/**
	 * @return the formSubscribe
	 */
	public static FormRegistration getFormSubscribe() {
		return formSubscribe;
	}

	/**
	 * @param formSubscribe the formSubscribe to set
	 */
	public static void setFormSubscribe(FormRegistration formSubscribe) {
		Main.formSubscribe = formSubscribe;
	}
	
}
