package model;

import entity.User;

public interface QueryUser {
	
	public User findOneById(int idUser);
	public User findOneByNickname(String nickname);
	public User findOneByEmail(String email);
	public User createUser(String nickname,String email,String name,String firstname,String city,String password);
	public User updateUser(User userToUpdate,String nickname,String email,String name,String firstname,String city);
	public void deleteUserByEmail(String email);

}
