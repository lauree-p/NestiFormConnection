package controller;

import entity.User;
import model.QueryUser;
import model.QueryUserImpl;
import tool.BCrypt;
import view.FormLogin;

public class LoginImpl implements Login {

	QueryUser queryUser = new QueryUserImpl();
	FormValidation formValidation = new FormValidationImpl();
	private static User userConnected;

	public User setConnectedUser() {
		User userConnected = null;
		if (findUser() != null
				& formValidation.ckeckNotEmptyTextField(String.valueOf(FormLogin.getPf_password().getPassword()))) {
			checkPasswordwithUsername();
		}

		return userConnected;
	}

	public boolean checkPasswordwithUsername() {
		boolean goodPassword = false;
		if (BCrypt.checkpw(String.valueOf(FormLogin.getPf_password().getPassword()), findUser().getPassword())) {
			goodPassword = true;
		}
		return goodPassword;
	}

	public User findUser() {
		User userFind = null;
		if (formValidation.checkValidEmail(FormLogin.getTf_username().getText())) {
			userFind = queryUser.findOneByEmail(FormLogin.getTf_username().getText());
		} else {
			userFind = queryUser.findOneByNickname(FormLogin.getTf_username().getText());
		}
		
		setUserConnected(userFind);
		
		return userFind;
	}

	public boolean fieldsNotEmpty() {
		boolean fieldsNotEmpty = false;
		if (formValidation.ckeckNotEmptyTextField(FormLogin.getTf_username().getText())
				&& formValidation.ckeckNotEmptyTextField(String.valueOf(FormLogin.getPf_password().getPassword()))) {
			fieldsNotEmpty = true;
		}

		return fieldsNotEmpty;
	}

	public boolean fieldPasswordNotEmpty() {
		boolean passwordNotEmpty = false;
		if (formValidation.ckeckNotEmptyTextField(String.valueOf(FormLogin.getPf_password().getPassword()))) {
			passwordNotEmpty = true;
		}

		return passwordNotEmpty;
	}

	public boolean fieldUsernameNotEmpty() {
		boolean usernameNotEmpty = false;
		if (formValidation.ckeckNotEmptyTextField(FormLogin.getTf_username().getText())) {
			usernameNotEmpty = true;
		}

		return usernameNotEmpty;
	}

	/**
	 * @return the userConnected
	 */
	public User getUserConnected() {
		return userConnected;
	}

	/**
	 * @param userConnected the userConnected to set
	 */
	public void setUserConnected(User userConnected) {
		LoginImpl.userConnected = userConnected;
	}


}
