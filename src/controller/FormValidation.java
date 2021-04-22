package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import entity.User;
import model.QueryUser;

/**
 * Class that validates the registration form
 * 
 * @author Laurée
 */
public class FormValidation {

	/**
	 * Check if all fields in the registration form are valid
	 * 
	 * @param nickname
	 * @param email
	 * @param pswd
	 * @param pswdConfirm
	 * @return Boolean[] with values true or false for each validation methods
	 */
	public static Boolean[] checkFormSubscribe(String nickname, String email, String password, String confirmPassword) {
		Boolean[] validFields = { checkValidNickname(nickname), ckeckNotEmptyTextField(nickname),
				checkValidEmail(email), ckeckNotEmptyTextField(email), ckeckEmailNotAlreadyUse(email),
				ckeckValidPassword(password), ckeckNotEmptyTextField(password),
				ckeckPswdConfirm(password, confirmPassword), ckeckNotEmptyTextField(confirmPassword), };
		return validFields;
	}

	/**
	 * Check if the field is not empty
	 * 
	 * @param textField
	 * @return
	 */
	public static boolean ckeckNotEmptyTextField(String textField) {
		Boolean textFieldNotEmpty = textField.equals("") ? false : true;
		return textFieldNotEmpty;
	}

	/**
	 * Nickname
	 */

	/**
	 * Check if the nickname format is valid
	 * 
	 * @param value
	 * @return true if it's a valid nickname
	 */
	public static boolean checkValidNickname(String nickname) {
		Boolean validNickname = false;
		final String regex = "^[A-Za-z0-9]{3,20}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(nickname);
		if (matcher.matches()) {
			validNickname = true;
		}
		return validNickname;
	}

	/**
	 * Email
	 */

	/**
	 * Check if the email format is valid
	 * 
	 * @param email
	 * @return true if it's a valid email
	 */
	public static boolean checkValidEmail(String email) {
		final String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	/**
	 * Check if the email is not already in use
	 * 
	 * @param email
	 * @return true if the email is not already in use
	 */
	public static boolean ckeckEmailNotAlreadyUse(String email) {
		User userFind = QueryUser.findOneByEmail(email);
		Boolean notEmptyNickname = userFind == null ? true : false;
		return notEmptyNickname;
	}

	/**
	 * Password
	 */

	/**
	 * 
	 * A valid password will have : 8 to 15 characters long - at least one lowercase
	 * letter - at least one upper case letter - at least one number - at least one
	 * of these special characters: $ @ % * + - _ ! - no other character possible:
	 * no & or {for example)
	 * 
	 * @param pswd
	 * @return true if it's a valid password
	 */
	public static boolean ckeckValidPassword(String password) {
		final String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[-+!*$@%_])([-+!*$@%_\\w]{8,25})$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}

	/**
	 * Check if the password confirmation matches the password
	 * 
	 * @param password
	 * @param confirmPassword
	 * @return true if the password confirmation matches the password
	 */
	public static boolean ckeckPswdConfirm(String password, String confirmPassword) {
		Boolean validPswdConfirm = false;
		if (password.equals(confirmPassword)) {
			validPswdConfirm = true;
			if (confirmPassword.equals("")) {
				validPswdConfirm = false;
			}
		}
		if (confirmPassword.equals("")) {
			validPswdConfirm = false;
		}
		return validPswdConfirm;
	}

}