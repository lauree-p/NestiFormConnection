package controller;

public interface Registration {

	String cryptPswd(String password);
	void createAccount();
	boolean registrationValidation();

}