package controller;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import entity.User;
import model.QueryUser;
import model.QueryUserImpl;

/**
 * Class that validates the registration form
 * 
 * @author Laurée
 */
public class FormValidationImpl implements FormValidation {

	@Override
	public ArrayList<Boolean> checkFormLogin(String username, String password) {
		ArrayList<Boolean> validFields = new ArrayList<Boolean>();
		// If username is a email
		if (checkValidEmail(username)) {
			validFields.add(checkValidEmail(username));
			validFields.add(ckeckNotEmptyTextField(username));
			validFields.add(ckeckEmailNotAlreadyUse(username));
		} else {
			validFields.add(checkValidNickname(username));
			validFields.add(ckeckNotEmptyTextField(username));
		}
		validFields.add(ckeckValidPassword(password));
		validFields.add(ckeckNotEmptyTextField(password));
		return validFields;
	}

	@Override
	public boolean checkFormLoginArray(ArrayList<Boolean> arrayBoolean) {
		boolean allTrue = true;
	    for (boolean b : arrayBoolean) {
	    	if(!b) {
	    		allTrue = false;
	    	}
	    }
		return allTrue;
	}

	/**
	 * Check if all fields in the registration form are valid
	 * 
	 * @param nickname
	 * @param email
	 * @param pswd
	 * @param pswdConfirm
	 * @return Boolean[] with values true or false for each validation methods
	 */
	@Override
	public boolean[] checkFormRegistration(String nickname, String email, String password, String confirmPassword) {
		boolean[] validFields = {
			// nickname
			checkValidNickname(nickname), // 0
			ckeckNotEmptyTextField(nickname), // 1
			// email
			checkValidEmail(email), // 2
			ckeckNotEmptyTextField(email), // 3
			ckeckEmailNotAlreadyUse(email), // 4
			// password
			ckeckValidPassword(password), // 5
			ckeckNotEmptyTextField(password), // 6
			// confirmPassword
			ckeckPswdConfirm(password, confirmPassword), // 7
			ckeckNotEmptyTextField(confirmPassword) // 8
		};
		return validFields;
	}

	@Override
	public boolean checkFormRegistrationArray(boolean[] arrayBoolean) {
		boolean allTrue = true;
	    for (boolean b : arrayBoolean) {
	    	if(!b) {
	    		allTrue = false;
	    	}
	    }
		return allTrue;
	}

	/**
	 * Check if the field is not empty
	 * 
	 * @param textField
	 * @return
	 */
	@Override
	public boolean ckeckNotEmptyTextField(String textField) {
		boolean textFieldNotEmpty = textField.equals("") ? false : true;
		return textFieldNotEmpty;
	}

	/**
	 * Check if the nickname format is valid
	 * 
	 * @param value
	 * @return true if it's a valid nickname
	 */
	@Override
	public boolean checkValidNickname(String nickname) {
		boolean validNickname = false;
		final String regex = "^[A-Za-z0-9]{3,20}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(nickname);
		if (matcher.matches()) {
			validNickname = true;
		}
		return validNickname;
	}

	/**
	 * Check if the email format is valid
	 * 
	 * @param email
	 * @return true if it's a valid email
	 */
	@Override
	public boolean checkValidEmail(String email) {
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
	@Override
	public boolean ckeckEmailNotAlreadyUse(String email) {
		QueryUser queryUser = new QueryUserImpl();
		User userFind = queryUser.findOneByEmail(email);
		Boolean notAlreadyUse = userFind == null ? true : false;
		return notAlreadyUse;
	}

	/**
	 * 
	 * A valid password will have : 8 to 20 characters long - at least one lowercase
	 * letter - at least one upper case letter - at least one number - at least one
	 * of these special characters: $ @ % * + - _ ! - no other character possible:
	 * no & or {for example)
	 * 
	 * @param pswd
	 * @return true if it's a valid password
	 */
	@Override
	public boolean ckeckValidPassword(String password) {
		final String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[-+!*$@%_])([-+!*$@%_\\w]{8,20})$";
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
	@Override
	public boolean ckeckPswdConfirm(String password, String confirmPassword) {
		boolean validPswdConfirm = false;
		if (password.equals(confirmPassword)) {
			validPswdConfirm = true;
		}
		return validPswdConfirm;
	}
}
