package controller;

import java.util.ArrayList;

public interface FormValidation {

	boolean[] checkFormRegistration(String nickname, String email, String password, String confirmPassword);
	boolean checkFormRegistrationArray(boolean[] arrayBoolean);
	
	ArrayList<Boolean> checkFormLogin(String username, String password);
	boolean checkFormLoginArray(ArrayList<Boolean> arrayBoolean);
	
	boolean ckeckNotEmptyTextField(String textField);
	boolean checkValidNickname(String nickname);
	boolean checkValidEmail(String email);
	boolean ckeckEmailNotAlreadyUse(String email);
	boolean ckeckValidPassword(String password);
	boolean ckeckPswdConfirm(String password, String confirmPassword);
}