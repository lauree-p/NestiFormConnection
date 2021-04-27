package controller;

import model.QueryUser;
import model.QueryUserImpl;
import tool.BCrypt;
import view.FormRegistration;

public class RegistrationImpl implements Registration {
	String nickname = FormRegistration.getTf_nickname().getText();
	String email = FormRegistration.getTf_email().getText();
	String name = FormRegistration.getTf_name().getText();
	String firstname = FormRegistration.getTf_firstname().getText();
	String city = FormRegistration.getTf_city().getText();
	String password = String.valueOf(FormRegistration.getTf_password().getPassword());
	String passwordConfirm = String.valueOf(FormRegistration.getTf_confirmPsw().getPassword());

	public boolean registrationValidation() {
		FormValidation formValidation = new FormValidationImpl();
		boolean[] checkFormRegistration = formValidation.checkFormRegistration(nickname, email, password, passwordConfirm);
		boolean formRegistrationValid = formValidation.checkFormRegistrationArray(checkFormRegistration);
		return formRegistrationValid;
	}
	
	public void createAccount() {
		QueryUser queryUser = new QueryUserImpl();
		queryUser.createUser(nickname, email, name, firstname, city, cryptPswd(password));
	}
		
	/**
	 * Encrypts the password
	 * 
	 * @param String password
	 * @return the password encrypted (String)
	 */
	public String cryptPswd(String password) {
		String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
		return hashed;
	}
}
