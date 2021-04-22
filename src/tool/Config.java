package tool;

public class Config {
	
	private static final String USERNAME = "root";
	private static final String PASSWORD =  "";
	private static final String URLBSD = "jdbc:mysql://localhost/nesti_formconnect";
	/**
	 * @return the username
	 */
	public static String getUsername() {
		return USERNAME;
	}
	/**
	 * @return the password
	 */
	public static String getPassword() {
		return PASSWORD;
	}
	/**
	 * @return the urlbsd
	 */
	public static String getUrlbsd() {
		return URLBSD;
	}

}
