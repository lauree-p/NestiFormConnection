package controller;

import entity.User;

public interface Login {
	
	User setConnectedUser();
	User findUser();
	boolean checkPasswordwithUsername();
	boolean fieldsNotEmpty();
	boolean fieldPasswordNotEmpty();
	boolean fieldUsernameNotEmpty();
	User getUserConnected();
	void setUserConnected(User userConnected);

}
