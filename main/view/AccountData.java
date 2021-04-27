package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Login;
import controller.LoginImpl;

@SuppressWarnings("serial")
public class AccountData extends JPanel {

	JPanel panel_hr_1, panel_hr_2;
	private JLabel lbl_my_account, lbl_info, lbl_nickname, lbl_email, lbl_name, lbl_firstname, lbl_city;
	private static JLabel lbl_user_nickname;
	private static JLabel lbl_user_email;
	private static JLabel lbl_user_name;
	private static JLabel lbl_user_firstname;
	private static JLabel lbl_user_city;
	JButton btn_update;

	/**
	 * Create the panel.
	 */
	public AccountData() {
		initialize();
		setBackground(new Color(67, 46, 46));
		setBounds(201, 0, 911, 634);
		setLayout(null);
		setVisible(true);
	}

	/**
	 * Initialize the contents of the panel.
	 */
	public void initialize() {
		Login login = new LoginImpl();
		lbl_my_account = new JLabel("MON COMPTE");
		lbl_my_account.setForeground(Color.WHITE);
		lbl_my_account.setFont(new Font("Montserrat", Font.BOLD, 28));
		lbl_my_account.setBounds(59, 123, 223, 35);
		add(lbl_my_account);

		lbl_info = new JLabel("Information détaillées");
		lbl_info.setForeground(Color.WHITE);
		lbl_info.setFont(new Font("Montserrat", Font.PLAIN, 20));
		lbl_info.setBounds(59, 180, 239, 35);
		add(lbl_info);

		panel_hr_1 = new JPanel();
		panel_hr_1.setBounds(59, 226, 365, 1);
		add(panel_hr_1);

		lbl_nickname = new JLabel("NOM D'UTILISATEUR");
		lbl_nickname.setFont(new Font("Montserrat", Font.PLAIN, 12));
		lbl_nickname.setForeground(Color.WHITE);
		lbl_nickname.setBounds(59, 249, 137, 14);
		add(lbl_nickname);

		lbl_email = new JLabel("EMAIL");
		lbl_email.setForeground(Color.WHITE);
		lbl_email.setFont(new Font("Montserrat", Font.PLAIN, 12));
		lbl_email.setBounds(59, 283, 137, 14);
		add(lbl_email);

		lbl_name = new JLabel("NOM");
		lbl_name.setForeground(Color.WHITE);
		lbl_name.setFont(new Font("Montserrat", Font.PLAIN, 12));
		lbl_name.setBounds(59, 321, 137, 14);
		add(lbl_name);

		lbl_firstname = new JLabel("PRENOM");
		lbl_firstname.setForeground(Color.WHITE);
		lbl_firstname.setFont(new Font("Montserrat", Font.PLAIN, 12));
		lbl_firstname.setBounds(59, 359, 137, 14);
		add(lbl_firstname);

		lbl_city = new JLabel("VILLE");
		lbl_city.setForeground(Color.WHITE);
		lbl_city.setFont(new Font("Montserrat", Font.PLAIN, 12));
		lbl_city.setBounds(59, 394, 137, 14);
		add(lbl_city);

		lbl_user_nickname = new JLabel(login.findUser().getNickname());
		lbl_user_nickname.setForeground(Color.WHITE);
		lbl_user_nickname.setFont(new Font("Montserrat", Font.PLAIN, 12));
		lbl_user_nickname.setBounds(206, 249, 218, 14);
		add(lbl_user_nickname);

		lbl_user_email = new JLabel(login.findUser().getEmail());
		lbl_user_email.setForeground(Color.WHITE);
		lbl_user_email.setFont(new Font("Montserrat", Font.PLAIN, 12));
		lbl_user_email.setBounds(206, 284, 218, 14);
		add(lbl_user_email);

		lbl_user_name = new JLabel(login.findUser().getName());
		lbl_user_name.setForeground(Color.WHITE);
		lbl_user_name.setFont(new Font("Montserrat", Font.PLAIN, 12));
		lbl_user_name.setBounds(206, 322, 218, 14);
		add(lbl_user_name);

		lbl_user_firstname = new JLabel(login.findUser().getFirstname());
		lbl_user_firstname.setForeground(Color.WHITE);
		lbl_user_firstname.setFont(new Font("Montserrat", Font.PLAIN, 12));
		lbl_user_firstname.setBounds(206, 360, 218, 14);
		add(lbl_user_firstname);

		lbl_user_city = new JLabel(login.findUser().getCity());
		lbl_user_city.setForeground(Color.WHITE);
		lbl_user_city.setFont(new Font("Montserrat", Font.PLAIN, 12));
		lbl_user_city.setBounds(206, 395, 218, 14);
		add(lbl_user_city);

	}
	
	// Getters & Setters

	/**
	 * @return the lbl_user_nickname
	 */
	public static JLabel getLbl_user_nickname() {
		return lbl_user_nickname;
	}

	/**
	 * @param lbl_user_nickname the lbl_user_nickname to set
	 */
	public void setLbl_user_nickname(JLabel lbl_user_nickname) {
		AccountData.lbl_user_nickname = lbl_user_nickname;
	}

	/**
	 * @return the lbl_user_email
	 */
	public static JLabel getLbl_user_email() {
		return lbl_user_email;
	}

	/**
	 * @param lbl_user_email the lbl_user_email to set
	 */
	public void setLbl_user_email(JLabel lbl_user_email) {
		AccountData.lbl_user_email = lbl_user_email;
	}

	/**
	 * @return the lbl_user_name
	 */
	public static JLabel getLbl_user_name() {
		return lbl_user_name;
	}

	/**
	 * @param lbl_user_name the lbl_user_name to set
	 */
	public void setLbl_user_name(JLabel lbl_user_name) {
		AccountData.lbl_user_name = lbl_user_name;
	}

	/**
	 * @return the lbl_user_firstname
	 */
	public static JLabel getLbl_user_firstname() {
		return lbl_user_firstname;
	}

	/**
	 * @param lbl_user_firstname the lbl_user_firstname to set
	 */
	public void setLbl_user_firstname(JLabel lbl_user_firstname) {
		AccountData.lbl_user_firstname = lbl_user_firstname;
	}

	/**
	 * @return the lbl_user_city
	 */
	public static JLabel getLbl_user_city() {
		return lbl_user_city;
	}

	/**
	 * @param lbl_user_city the lbl_user_city to set
	 */
	public void setLbl_user_city(JLabel lbl_user_city) {
		AccountData.lbl_user_city = lbl_user_city;
	}

}
