package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import entity.User;
import model.QueryUser;

@SuppressWarnings("serial")
public class AccountDataUpdate extends JPanel {

	private static JTextField textField_up_user_city;
	private static JTextField textField_up_user_nickname;
	private static JTextField textField_up_user_email;
	private static JTextField textField_up_user_name;
	private static JTextField textField_up_user_firstname;
	private JLabel lbl_up_my_account, lbl_up_nickname, lbl_up_email, lbl_up_name, lbl_up_firstname, lbl_up_city,
			lbl_up_update;
	private JPanel panel_up_hr_2, panel_up_hr_1;
	private JButton btn_up_cancel, btn_up_update;
	private static User userUpdated;

	/**
	 * Create the panel.
	 */
	public AccountDataUpdate() {
		initialize();
		setBackground(new Color(67, 46, 46));
		setBounds(201, 0, 911, 634);
		setLayout(null);
		setVisible(false);
	}

	/**
	 * Initialize the contents of the panel.
	 */
	public void initialize() {

		lbl_up_my_account = new JLabel("MON COMPTE");
		lbl_up_my_account.setForeground(Color.WHITE);
		lbl_up_my_account.setFont(new Font("Montserrat", Font.BOLD, 28));
		lbl_up_my_account.setBounds(59, 123, 223, 35);
		add(lbl_up_my_account);

		lbl_up_update = new JLabel("Modifier mon compte");
		lbl_up_update.setForeground(Color.WHITE);
		lbl_up_update.setFont(new Font("Montserrat", Font.PLAIN, 20));
		lbl_up_update.setBounds(59, 180, 239, 35);
		add(lbl_up_update);

		panel_up_hr_1 = new JPanel();
		panel_up_hr_1.setBounds(59, 226, 365, 1);
		add(panel_up_hr_1);

		lbl_up_nickname = new JLabel("NOM D'UTILISATEUR");
		lbl_up_nickname.setForeground(Color.WHITE);
		lbl_up_nickname.setFont(new Font("Montserrat", Font.PLAIN, 12));
		lbl_up_nickname.setBounds(59, 249, 137, 14);
		add(lbl_up_nickname);

		lbl_up_email = new JLabel("EMAIL");
		lbl_up_email.setForeground(Color.WHITE);
		lbl_up_email.setFont(new Font("Montserrat", Font.PLAIN, 12));
		lbl_up_email.setBounds(59, 283, 137, 14);
		add(lbl_up_email);

		lbl_up_name = new JLabel("NOM");
		lbl_up_name.setForeground(Color.WHITE);
		lbl_up_name.setFont(new Font("Montserrat", Font.PLAIN, 12));
		lbl_up_name.setBounds(59, 321, 137, 14);
		add(lbl_up_name);

		lbl_up_firstname = new JLabel("PRENOM");
		lbl_up_firstname.setForeground(Color.WHITE);
		lbl_up_firstname.setFont(new Font("Montserrat", Font.PLAIN, 12));
		lbl_up_firstname.setBounds(59, 359, 137, 14);
		add(lbl_up_firstname);

		lbl_up_city = new JLabel("VILLE");
		lbl_up_city.setForeground(Color.WHITE);
		lbl_up_city.setFont(new Font("Montserrat", Font.PLAIN, 12));
		lbl_up_city.setBounds(59, 394, 137, 14);
		add(lbl_up_city);

		panel_up_hr_2 = new JPanel();
		panel_up_hr_2.setBounds(59, 434, 365, 1);
		add(panel_up_hr_2);

		btn_up_update = new JButton("ENREGISTRER LES MODIFICATIONS");
		btn_up_update.setHorizontalAlignment(SwingConstants.LEFT);
		btn_up_update.setForeground(Color.WHITE);
		btn_up_update.setFont(new Font("Montserrat", Font.PLAIN, 12));
		btn_up_update.setBackground(new Color(67, 46, 46));
		btn_up_update.setBounds(59, 461, 273, 23);
		btn_up_update.setFocusable(false);
		add(btn_up_update);

		btn_up_cancel = new JButton("ANNULER");
		btn_up_cancel.setHorizontalAlignment(SwingConstants.LEFT);
		btn_up_cancel.setForeground(Color.WHITE);
		btn_up_cancel.setFont(new Font("Montserrat", Font.PLAIN, 12));
		btn_up_cancel.setBackground(new Color(67, 46, 46));
		btn_up_cancel.setBounds(357, 461, 230, 23);
		add(btn_up_cancel);

		textField_up_user_nickname = new JTextField();
		textField_up_user_nickname.setText(FormLogin.getUserConnected().getNickname());
		textField_up_user_nickname.setFont(new Font("Montserrat", Font.PLAIN, 12));
		textField_up_user_nickname.setColumns(10);
		textField_up_user_nickname.setBounds(206, 245, 218, 23);
		add(textField_up_user_nickname);

		textField_up_user_email = new JTextField();
		textField_up_user_email.setText(FormLogin.getUserConnected().getEmail());
		textField_up_user_email.setFont(new Font("Montserrat", Font.PLAIN, 12));
		textField_up_user_email.setColumns(10);
		textField_up_user_email.setBounds(206, 279, 218, 23);
		add(textField_up_user_email);

		textField_up_user_name = new JTextField();
		textField_up_user_name.setText(FormLogin.getUserConnected().getName());
		textField_up_user_name.setFont(new Font("Montserrat", Font.PLAIN, 12));
		textField_up_user_name.setColumns(10);
		textField_up_user_name.setBounds(206, 317, 218, 23);
		add(textField_up_user_name);

		textField_up_user_firstname = new JTextField();
		textField_up_user_firstname.setText(FormLogin.getUserConnected().getFirstname());
		textField_up_user_firstname.setFont(new Font("Montserrat", Font.PLAIN, 12));
		textField_up_user_firstname.setColumns(10);
		textField_up_user_firstname.setBounds(206, 355, 218, 23);
		add(textField_up_user_firstname);
		
		textField_up_user_city = new JTextField();
		textField_up_user_city.setFont(new Font("Montserrat", Font.PLAIN, 12));
		textField_up_user_city.setText(FormLogin.getUserConnected().getCity());
		textField_up_user_city.setBounds(206, 390, 218, 23);
		textField_up_user_city.setColumns(10);
		add(textField_up_user_city);
		
		btn_up_update.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setUserUpdated(updateUser());
				AccountData.getLbl_user_nickname().setText(getUserUpdated().getNickname());
			}
		});
		
		btn_up_cancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				textField_up_user_nickname.setText(FormLogin.getUserConnected().getNickname());
				textField_up_user_email.setText(FormLogin.getUserConnected().getEmail());
				textField_up_user_name.setText(FormLogin.getUserConnected().getName());
				textField_up_user_firstname.setText(FormLogin.getUserConnected().getFirstname());
				textField_up_user_city.setText(FormLogin.getUserConnected().getCity());
			}
		});
		
	}
	
	public static User updateUser() {
		System.out.println("Clique sur Enregistrer modification");
		String nicknameUpdate = textField_up_user_nickname.getText();
		String emailUpdate = textField_up_user_email.getText();
		String nameUpdate = textField_up_user_name.getText();
		String firstnameUpdate = textField_up_user_firstname.getText();
		String cityUpdate = textField_up_user_city.getText();
		return QueryUser.updateUser(nicknameUpdate, emailUpdate, nameUpdate, firstnameUpdate, cityUpdate);
	}

	/**
	 * @return the userUpdated
	 */
	public static User getUserUpdated() {
		return userUpdated;
	}

	/**
	 * @param userUpdated the userUpdated to set
	 */
	public static void setUserUpdated(User userUpdated) {
		AccountDataUpdate.userUpdated = userUpdated;
	}

	

}
