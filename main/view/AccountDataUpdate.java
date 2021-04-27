package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import controller.FormValidation;
import controller.FormValidationImpl;
import controller.Login;
import controller.LoginImpl;
import entity.User;
import model.QueryUser;
import model.QueryUserImpl;

@SuppressWarnings("serial")
public class AccountDataUpdate extends JPanel {

	private static JTextField textField_up_user_city;
	private static JTextField textField_up_user_nickname;
	private static JTextField textField_up_user_email;
	private static JTextField textField_up_user_name;
	private static JTextField textField_up_user_firstname;
	private JLabel lbl_up_my_account, lbl_up_nickname, lbl_up_email, lbl_up_name, lbl_up_firstname, lbl_up_city,
			lbl_up_update;
	private static JLabel lbl_error_nickname;
	private static JLabel lbl_error_email;
	private JPanel panel_up_hr_2, panel_up_hr_1;
	private JButton btn_up_cancel, btn_up_update;
	private static Border lineborderRed = BorderFactory.createLineBorder(Color.red, 1);
	private static Border lineborderWhite = BorderFactory.createLineBorder(Color.white, 1);

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
		Login login = new LoginImpl();
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
		textField_up_user_nickname.setText(login.findUser().getNickname());
		textField_up_user_nickname.setFont(new Font("Montserrat", Font.PLAIN, 12));
		textField_up_user_nickname.setColumns(10);
		textField_up_user_nickname.setBounds(206, 245, 218, 23);
		add(textField_up_user_nickname);

		textField_up_user_email = new JTextField();
		textField_up_user_email.setText(login.findUser().getEmail());
		textField_up_user_email.setFont(new Font("Montserrat", Font.PLAIN, 12));
		textField_up_user_email.setColumns(10);
		textField_up_user_email.setBounds(206, 279, 218, 23);
		add(textField_up_user_email);

		textField_up_user_name = new JTextField();
		textField_up_user_name.setText(login.findUser().getName());
		textField_up_user_name.setFont(new Font("Montserrat", Font.PLAIN, 12));
		textField_up_user_name.setColumns(10);
		textField_up_user_name.setBounds(206, 317, 218, 23);
		add(textField_up_user_name);

		textField_up_user_firstname = new JTextField();
		textField_up_user_firstname.setText(login.findUser().getFirstname());
		textField_up_user_firstname.setFont(new Font("Montserrat", Font.PLAIN, 12));
		textField_up_user_firstname.setColumns(10);
		textField_up_user_firstname.setBounds(206, 355, 218, 23);
		add(textField_up_user_firstname);

		textField_up_user_city = new JTextField();
		textField_up_user_city.setFont(new Font("Montserrat", Font.PLAIN, 12));
		textField_up_user_city.setText(login.findUser().getCity());
		textField_up_user_city.setBounds(206, 390, 218, 23);
		textField_up_user_city.setColumns(10);
		add(textField_up_user_city);

		lbl_error_nickname = new JLabel();
		lbl_error_nickname.setForeground(Color.RED);
		lbl_error_nickname.setFont(new Font("Montserrat", Font.PLAIN, 10));
		lbl_error_nickname.setBounds(434, 250, 282, 14);
		lbl_error_nickname.setVisible(false);
		add(lbl_error_nickname);

		lbl_error_email = new JLabel();
		lbl_error_email.setForeground(Color.RED);
		lbl_error_email.setFont(new Font("Montserrat", Font.PLAIN, 10));
		lbl_error_email.setBounds(434, 284, 282, 14);
		lbl_error_email.setVisible(false);
		add(lbl_error_email);

		btn_up_update.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("Clique sur Enregistrer modification");
				if (validationUpdate()) {
					updateUserDb();
					App.setUserConnected(updateUser());

					AccountData.getLbl_user_nickname().setText(updateUser().getNickname());
					AccountData.getLbl_user_name().setText(updateUser().getName());
					AccountData.getLbl_user_firstname().setText(updateUser().getFirstname());
					AccountData.getLbl_user_email().setText(updateUser().getEmail());
					AccountData.getLbl_user_city().setText(updateUser().getCity());

					setVisible(false);
					App.getPanel_my_account_info().setVisible(true);
				}

			}
		});

		btn_up_cancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				resetUpdate();
			}
		});

	}

	public static User updateUser() {
		User userNewData = new User(textField_up_user_nickname.getText(), textField_up_user_email.getText(),
				textField_up_user_name.getText(), textField_up_user_firstname.getText(),
				textField_up_user_city.getText());

		return userNewData;
	}

	public static void updateUserDb() {
		QueryUser queryUser = new QueryUserImpl();
		Login login = new LoginImpl();

		queryUser.updateUser(login.findUser(), textField_up_user_nickname.getText(), textField_up_user_email.getText(),
				textField_up_user_name.getText(), textField_up_user_firstname.getText(),
				textField_up_user_city.getText());
		JButton btnNewButton = new JButton("OK");
		JOptionPane.showMessageDialog(btnNewButton, "Votre compte à bien était Modifier !");
	}

	public static void resetUpdate() {
		textField_up_user_nickname.setText(App.getUserConnected().getNickname());
		textField_up_user_email.setText(App.getUserConnected().getEmail());
		textField_up_user_name.setText(App.getUserConnected().getName());
		textField_up_user_firstname.setText(App.getUserConnected().getFirstname());
		textField_up_user_city.setText(App.getUserConnected().getCity());
		setBorderColor(textField_up_user_nickname, lineborderWhite);
		setBorderColor(textField_up_user_email, lineborderWhite);
		lbl_error_nickname.setVisible(false);
		lbl_error_email.setVisible(false);
	}

	public static boolean validationUpdate() {
		FormValidation formValidation = new FormValidationImpl();

		String nickname = textField_up_user_nickname.getText();
		String email = textField_up_user_email.getText();
		boolean validNickname = false;
		boolean validEmail = false;
		boolean validUpdate = false;

		if (formValidation.ckeckNotEmptyTextField(nickname)) {
			if (!formValidation.checkValidNickname(nickname)) {
				lbl_error_nickname.setVisible(true);
				lbl_error_nickname.setText("Caractères spéciaux non autorisés. De 3 à 20 caratères.");
				setBorderColor(textField_up_user_nickname, lineborderRed);
			} else {
				validNickname = true;
				lbl_error_nickname.setVisible(false);
				setBorderColor(textField_up_user_nickname, lineborderWhite);
			}

		} else {
			lbl_error_nickname.setVisible(true);
			lbl_error_nickname.setText("Champ obligatoire. Saisissez votre nom d'utilisateur.");
		}

		if (formValidation.ckeckNotEmptyTextField(email)) {
			if (formValidation.checkValidEmail(email)) {
				if (!formValidation.ckeckEmailNotAlreadyUse(email)) {
					System.out.println(App.getUserConnected().getEmail());
					if (!App.getUserConnected().getEmail().equals(email)) {
						lbl_error_email.setVisible(true);
						lbl_error_email.setText("Adresse e-mail déjà utilisée !");
						setBorderColor(textField_up_user_email, lineborderRed);
					} else {
						lbl_error_email.setVisible(false);
						validEmail = true;
						setBorderColor(textField_up_user_email, lineborderWhite);
					}
				} else {
					lbl_error_email.setVisible(false);
					validEmail = true;
					setBorderColor(textField_up_user_email, lineborderWhite);
				}
			} else {
				lbl_error_email.setVisible(true);
				lbl_error_email.setText("Adresse e-mail non valide !");
				setBorderColor(textField_up_user_email, lineborderRed);
			}

		} else {
			lbl_error_email.setVisible(true);
			lbl_error_email.setText("Champ obligatoire. Saisissez votre adresse e-mail.");
			setBorderColor(textField_up_user_email, lineborderRed);
		}

		if (validNickname && validEmail) {
			validUpdate = true;
		}

		return validUpdate;
	}

	/**
	 * 
	 */
	public static void setBorderColor(JTextField jTexField, Border border) {
		jTexField.setBorder(border);
	}

	/**
	 * @return the lbl_error_nickname
	 */
	public JLabel getLbl_error_nickname() {
		return lbl_error_nickname;
	}

	/**
	 * @param lbl_error_nickname the lbl_error_nickname to set
	 */
	public void setLbl_error_nickname(JLabel lbl_error_nickname) {
		AccountDataUpdate.lbl_error_nickname = lbl_error_nickname;
	}

	/**
	 * @return the lineborderRed
	 */
	public static Border getLineborderRed() {
		return lineborderRed;
	}

	/**
	 * @param lineborderRed the lineborderRed to set
	 */
	public static void setLineborderRed(Border lineborderRed) {
		AccountDataUpdate.lineborderRed = lineborderRed;
	}

	/**
	 * @return the lineborderWhite
	 */
	public static Border getLineborderWhite() {
		return lineborderWhite;
	}

	/**
	 * @param lineborderWhite the lineborderWhite to set
	 */
	public static void setLineborderWhite(Border lineborderWhite) {
		AccountDataUpdate.lineborderWhite = lineborderWhite;
	}
}
