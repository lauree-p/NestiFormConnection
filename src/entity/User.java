package entity;

public class User {
	
	private int idUser;
	private String nickname;
	private String email;
	private String name;
	private String firstname;
	private String city;
	private String password;
	
	
	public User() {
		
	}
	
	/**
	 * @param idUser
	 * @param nickname
	 * @param email
	 * @param name
	 * @param firstname
	 * @param city
	 * @param password
	 */
	public User(int idUser, String nickname, String email, String name, String firstname, String city,
			String password) {
		super();
		this.idUser = idUser;
		this.nickname = nickname;
		this.email = email;
		this.name = name;
		this.firstname = firstname;
		this.city = city;
		this.password = password;
	}

	/**
	 * @return the idUser
	 */
	public int getIdUser() {
		return idUser;
	}
	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}

