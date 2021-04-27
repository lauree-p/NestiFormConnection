package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;

import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

import controller.FormValidation;
import controller.FormValidationImpl;
import controller.Registration;
import controller.RegistrationImpl;
import main.Main;
import tool.BCrypt;
import tool.ImagePanel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;

/**
 * Class of view registration form
 * 
 * @author Lauree
 *
 */
@SuppressWarnings("serial")
public class FormRegistration extends JFrame {

	private static JPanel pl_subscribe;
	private JPanel pl_title_subscribe;
	private static JPanel pl_br;
	private JLabel lbl_pseudo, lbl_confirmPsw, lbl_email, lbl_firstname, lbl_name, lbl_password, lbl_city,
			lbl_subscribe;
	private static JLabel lbl_alreadyRegistered;
	private JLabel lbl_requiredFields;
	private JButton btn_createAccount, btn_cancel;
	private static JButton btn_login;
	private static JPasswordField tf_password, tf_confirmPsw;
	private static JLabel tp_error_nickname, tp_error_email, tp_error_confirmPsw, tp_error_password;
	private static JTextArea tp_error_validPassword;
	private static Border lineborderRed = BorderFactory.createLineBorder(Color.red, 1);
	private static Border lineborderWhite = BorderFactory.createLineBorder(Color.white, 1);
	private static Font fontTextField = new Font("Montserrat", Font.PLAIN, 12);
	private static JTextField tf_nickname, tf_email, tf_name, tf_firstname, tf_city;
	static FormValidation formValidation;
	Registration registration;
	
	/**
	 * Create the frame.
	 */
	public FormRegistration() {
		initialize();
		setBounds(100, 100, 634, 649);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		pl_subscribe = new JPanel();
		pl_subscribe.setBackground(new Color(67, 46, 46));
		pl_subscribe.setBounds(0, 0, 619, 595);
		pl_subscribe.setLayout(null);
		getContentPane().add(pl_subscribe);

		ImagePanel pl_logo = new ImagePanel(new ImageIcon(getClass().getResource("/img/logo.png")).getImage());
		pl_logo.setBounds(159, 11, 85, 85);
		pl_logo.setLayout(null);
		pl_subscribe.add(pl_logo);

		pl_title_subscribe = new JPanel();
		pl_title_subscribe.setBounds(0, 24, 619, 48);
		pl_title_subscribe.setBackground(new Color(191, 163, 124));
		pl_title_subscribe.setLayout(null);
		pl_subscribe.add(pl_title_subscribe);

		pl_br = new JPanel();
		pl_br.setBorder(new CompoundBorder());
		pl_br.setBounds(43, 550, 535, 1);
		pl_subscribe.add(pl_br);

		lbl_pseudo = new JLabel("NOM D'UTILISATEUR *");
		lbl_pseudo.setFont(new Font("Montserrat", Font.PLAIN, 13));
		lbl_pseudo.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_pseudo.setForeground(Color.WHITE);
		lbl_pseudo.setBounds(0, 120, 151, 30);
		pl_subscribe.add(lbl_pseudo);

		lbl_confirmPsw = new JLabel("CONFIRMATION *");
		lbl_confirmPsw.setFont(new Font("Montserrat", Font.PLAIN, 13));
		lbl_confirmPsw.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_confirmPsw.setForeground(Color.WHITE);
		lbl_confirmPsw.setBounds(0, 451, 151, 29);
		pl_subscribe.add(lbl_confirmPsw);

		lbl_email = new JLabel("EMAIL *");
		lbl_email.setFont(new Font("Montserrat", Font.PLAIN, 13));
		lbl_email.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_email.setForeground(Color.WHITE);
		lbl_email.setBounds(0, 175, 151, 30);
		pl_subscribe.add(lbl_email);

		lbl_firstname = new JLabel("PRENOM");
		lbl_firstname.setFont(new Font("Montserrat", Font.PLAIN, 13));
		lbl_firstname.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_firstname.setForeground(Color.WHITE);
		lbl_firstname.setBounds(0, 285, 144, 30);
		pl_subscribe.add(lbl_firstname);

		lbl_name = new JLabel("NOM");
		lbl_name.setFont(new Font("Montserrat", Font.PLAIN, 13));
		lbl_name.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_name.setForeground(Color.WHITE);
		lbl_name.setBounds(0, 229, 144, 30);
		pl_subscribe.add(lbl_name);

		lbl_password = new JLabel("MOT DE PASSE *");
		lbl_password.setFont(new Font("Montserrat", Font.PLAIN, 13));
		lbl_password.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_password.setForeground(Color.WHITE);
		lbl_password.setBounds(0, 395, 151, 30);
		pl_subscribe.add(lbl_password);

		lbl_city = new JLabel("VILLE");
		lbl_city.setFont(new Font("Montserrat", Font.PLAIN, 13));
		lbl_city.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_city.setForeground(Color.WHITE);
		lbl_city.setBounds(0, 340, 144, 30);
		pl_subscribe.add(lbl_city);

		lbl_subscribe = new JLabel("INSCRIPTION");
		lbl_subscribe.setForeground(Color.WHITE);
		lbl_subscribe.setFont(new Font("Montserrat", Font.BOLD, 12));
		lbl_subscribe.setBounds(262, 0, 357, 48);
		pl_title_subscribe.add(lbl_subscribe);

		lbl_alreadyRegistered = new JLabel("Déjà Inscrit ?");
		lbl_alreadyRegistered.setFont(new Font("Montserrat", Font.BOLD, 12));
		lbl_alreadyRegistered.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_alreadyRegistered.setForeground(Color.WHITE);
		lbl_alreadyRegistered.setBounds(43, 565, 108, 30);
		pl_subscribe.add(lbl_alreadyRegistered);

		lbl_requiredFields = new JLabel("* Champs obligatoire");
		lbl_requiredFields.setFont(new Font("Montserrat", Font.PLAIN, 11));
		lbl_requiredFields.setForeground(Color.LIGHT_GRAY);
		lbl_requiredFields.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_requiredFields.setBounds(396, 95, 148, 14);
		pl_subscribe.add(lbl_requiredFields);

		tf_nickname = new JTextField();
		tf_nickname.setBounds(159, 120, 385, 30);
		tf_nickname.setColumns(10);
		tf_nickname.requestFocus();
		tf_nickname.setBackground(new Color(67, 46, 46));
		tf_nickname.setForeground(Color.WHITE);
		tf_nickname.setCaretColor(Color.WHITE);
		tf_nickname.setBorder(BorderFactory.createCompoundBorder(tf_nickname.getBorder(),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		tf_nickname.setFont(fontTextField);
		pl_subscribe.add(tf_nickname);

		tf_email = new JTextField();
		tf_email.setColumns(10);
		tf_email.setBounds(159, 175, 385, 30);
		tf_email.setBackground(new Color(67, 46, 46));
		tf_email.setForeground(Color.WHITE);
		tf_email.setBorder(
				BorderFactory.createCompoundBorder(tf_email.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		tf_email.setCaretColor(Color.WHITE);
		tf_email.setFont(fontTextField);
		pl_subscribe.add(tf_email);

		tf_firstname = new JTextField();
		tf_firstname.setColumns(10);
		tf_firstname.setBounds(159, 230, 385, 30);
		tf_firstname.setBackground(new Color(67, 46, 46));
		tf_firstname.setForeground(Color.WHITE);
		tf_firstname.setCaretColor(Color.WHITE);
		tf_firstname.setFont(fontTextField);
		tf_firstname.setBorder(BorderFactory.createCompoundBorder(tf_firstname.getBorder(),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		pl_subscribe.add(tf_firstname);

		tf_name = new JTextField();
		tf_name.setColumns(10);
		tf_name.setBounds(159, 285, 385, 30);
		tf_name.setBackground(new Color(67, 46, 46));
		tf_name.setForeground(Color.WHITE);
		tf_name.setCaretColor(Color.WHITE);
		tf_name.setBorder(
				BorderFactory.createCompoundBorder(tf_name.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		tf_name.setFont(fontTextField);
		pl_subscribe.add(tf_name);

		tf_city = new JTextField();
		tf_city.setColumns(10);
		tf_city.setBounds(159, 340, 385, 30);
		tf_city.setBackground(new Color(67, 46, 46));
		tf_city.setForeground(Color.WHITE);
		tf_city.setCaretColor(Color.WHITE);
		tf_city.setBorder(
				BorderFactory.createCompoundBorder(tf_city.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		tf_city.setFont(fontTextField);
		pl_subscribe.add(tf_city);

		tf_password = new JPasswordField();
		tf_password.setColumns(10);
		tf_password.setBounds(159, 395, 385, 30);
		tf_password.setBackground(new Color(67, 46, 46));
		tf_password.setForeground(Color.WHITE);
		tf_password.setCaretColor(Color.WHITE);
		tf_password.setBorder(BorderFactory.createCompoundBorder(tf_password.getBorder(),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		tf_password.setFont(fontTextField);
		pl_subscribe.add(tf_password);

		tf_confirmPsw = new JPasswordField();
		tf_confirmPsw.setColumns(10);
		tf_confirmPsw.setBounds(159, 450, 385, 30);
		tf_confirmPsw.setBackground(new Color(67, 46, 46));
		tf_confirmPsw.setForeground(Color.WHITE);
		tf_confirmPsw.setCaretColor(Color.WHITE);
		tf_confirmPsw.setBorder(BorderFactory.createCompoundBorder(tf_confirmPsw.getBorder(),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		tf_confirmPsw.setFont(fontTextField);
		pl_subscribe.add(tf_confirmPsw);

		btn_createAccount = new JButton("CREER SON COMPTE");
		btn_createAccount.setHorizontalAlignment(SwingConstants.LEFT);
		btn_createAccount.setFont(new Font("Montserrat", Font.PLAIN, 11));
		btn_createAccount.setBorderPainted(false);
		btn_createAccount.setBounds(159, 509, 215, 30);
		btn_createAccount.setBackground(new Color(85, 65, 65));
		btn_createAccount.setForeground(Color.WHITE);
		btn_createAccount.setFocusable(false);
		pl_subscribe.add(btn_createAccount);

		btn_cancel = new JButton("ANNULER");
		btn_cancel.setHorizontalAlignment(SwingConstants.LEFT);
		btn_cancel.setFont(new Font("Montserrat", Font.PLAIN, 11));
		btn_cancel.setBounds(406, 509, 138, 29);
		btn_cancel.setBackground(new Color(191, 163, 124));
		btn_cancel.setForeground(Color.WHITE);
		btn_cancel.setBorderPainted(false);
		btn_cancel.setFocusable(false);
		pl_subscribe.add(btn_cancel);

		btn_login = new JButton("SE CONNECTER");
		btn_login.setHorizontalAlignment(SwingConstants.LEFT);
		btn_login.setFont(new Font("Montserrat", Font.PLAIN, 11));
		btn_login.setBounds(159, 565, 180, 30);
		btn_login.setBorderPainted(false);
		btn_login.setBackground(new Color(85, 65, 65));
		btn_login.setForeground(Color.WHITE);
		btn_login.setFocusable(false);
		pl_subscribe.add(btn_login);

		tp_error_nickname = new JLabel();
		tp_error_nickname.setFont(new Font("Montserrat", Font.PLAIN, 10));
		tp_error_nickname.setText("Caractére spéciaux non autorisés. De 3 à 20 caratères.");
		tp_error_nickname.setBounds(159, 152, 385, 20);
		tp_error_nickname.setBackground(new Color(67, 46, 46));
		tp_error_nickname.setForeground(Color.WHITE);
		tp_error_nickname.setBorder(BorderFactory.createCompoundBorder(tp_error_nickname.getBorder(),
				BorderFactory.createEmptyBorder(3, 3, 3, 3)));
		tp_error_nickname.setVisible(false);
		// tp_error_nickname.setEditable(false);
		pl_subscribe.add(tp_error_nickname);

		tp_error_email = new JLabel();
		tp_error_email.setText("Adresse-email déjà utilisé.");
		tp_error_email.setFont(new Font("Montserrat", Font.PLAIN, 10));
		tp_error_email.setBounds(159, 207, 385, 20);
		tp_error_email.setBackground(new Color(67, 46, 46));
		tp_error_email.setForeground(Color.WHITE);
		tp_error_email.setBorder(BorderFactory.createCompoundBorder(tp_error_email.getBorder(),
				BorderFactory.createEmptyBorder(3, 3, 3, 3)));
		tp_error_email.setVisible(false);
		pl_subscribe.add(tp_error_email);

		tp_error_confirmPsw = new JLabel();
		tp_error_confirmPsw.setText("La confirmation de votre mot de passe n'est pas valide.");
		tp_error_confirmPsw.setFont(new Font("Montserrat", Font.PLAIN, 10));
		tp_error_confirmPsw.setBounds(161, 482, 385, 20);
		tp_error_confirmPsw.setBackground(new Color(67, 46, 46));
		tp_error_confirmPsw.setForeground(Color.WHITE);
		tp_error_confirmPsw.setBorder(BorderFactory.createCompoundBorder(tp_error_confirmPsw.getBorder(),
				BorderFactory.createEmptyBorder(3, 3, 3, 3)));
		tp_error_confirmPsw.setVisible(false);
		pl_subscribe.add(tp_error_confirmPsw);

		tp_error_validPassword = new JTextArea();
		tp_error_validPassword.setFont(new Font("Montserrat", Font.PLAIN, 10));
		tp_error_validPassword.setLineWrap(true);
		tp_error_validPassword.setText(
				"Un mot de passe valide aura :\r\n- de 8 à 15 caractères\r\n- au moins une lettre minuscule\r\n- au moins une lettre majuscule\r\n- au moins un chiffre\r\n- au moins un de ces caractères spéciaux: $ @ % * + - _ !\r\n- aucun autre caractère possible: pas de & ni de {par exemple)");
		tp_error_validPassword.setBounds(159, 550, 385, 103);
		tp_error_validPassword.setBackground(new Color(67, 46, 46));
		tp_error_validPassword.setForeground(Color.WHITE);
		tp_error_validPassword.setBorder(lineborderRed);
		tp_error_validPassword.setBorder(BorderFactory.createCompoundBorder(tp_error_validPassword.getBorder(),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		tp_error_validPassword.setVisible(false);
		tp_error_validPassword.setEditable(false);
		pl_subscribe.add(tp_error_validPassword);

		tp_error_password = new JLabel();
		tp_error_password.setFont(new Font("Montserrat", Font.PLAIN, 10));
		tp_error_password.setText("Votre mot de passe n'est pas assez fort.");
		tp_error_password.setBounds(156, 427, 385, 20);
		tp_error_password.setBackground(new Color(67, 46, 46));
		tp_error_password.setForeground(Color.WHITE);
		tp_error_password.setBorder(BorderFactory.createCompoundBorder(tp_error_confirmPsw.getBorder(),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		tp_error_password.setVisible(false);
		pl_subscribe.add(tp_error_password);

		// Action onclick on btn_createAccount
		btn_createAccount.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				registration = new RegistrationImpl();
				formValidation = new FormValidationImpl();
				if (registration.registrationValidation()) {
					registration.createAccount();
					JButton btnNewButton = new JButton("OK");
					JOptionPane.showMessageDialog(btnNewButton, "Votre compte à bien était crée !");
					Main.getFormSubscribe().setVisible(false);
					Main.getFormLogin().setVisible(true);
				} else {
					String nickname = tf_nickname.getText();
					String email = tf_email.getText();
					String password = String.valueOf(tf_password.getPassword());
					String passwordConfirm = String.valueOf(tf_confirmPsw.getPassword());
					boolean[] checkFormRegistration = formValidation.checkFormRegistration(nickname, email, password, passwordConfirm);
					displayErrors(checkFormRegistration);
				}

			}
		});

		// Action onclick on btn_login
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBoundsIfNoErrors();
				resetFields();
				Main.getFormSubscribe().setVisible(false);
				Main.getFormLogin().setVisible(true);
			}
		});

		// Action onclick on btn_cancel
		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBoundsIfNoErrors();
				resetFields();
			}
		});
	}

	/**
	 * 
	 * @param textFields
	 * @return 
	 * @return
	 */
	public static void displayErrors(boolean[] textFields) {
		formValidation = new FormValidationImpl();
		setBoundsIfNoErrors();

		// checkNickname
		if (textFields[0] & textFields[1]) {
			tp_error_nickname.setVisible(false);
			setBorderColorAndPadding(tf_nickname, lineborderWhite);
		} else {
			tp_error_nickname.setVisible(true);
			setBorderColorAndPadding(tf_nickname, lineborderRed);
			if (!textFields[0]) {
				tp_error_nickname.setText("Caractères spéciaux non autorisés. De 3 à 20 caractères.");
			}
			if (!textFields[1]) {
				tp_error_nickname.setText("Champ obligatoire. Saisissez votre nom d'utilisateur.");
			}
		}

		// checkEmail
		if (textFields[2] & textFields[3] & textFields[4]) {
			tp_error_email.setVisible(false);
			setBorderColorAndPadding(tf_email, lineborderWhite);
		} else {
			tp_error_email.setVisible(true);
			setBorderColorAndPadding(tf_email, lineborderRed);
			if (!textFields[2]) {
				tp_error_email.setText("Cet adresse e-mail n'est pas valide.");
			}
			if (!textFields[3]) {
				tp_error_email.setText("Champ obligatoire. Saisissez votre adresse e-mail.");
			}
			if (!textFields[4]) {
				tp_error_email.setText("Adresse e-mail déjà utilisée.");
			}
		}

		// checkPassword
		if (textFields[5] & textFields[6]) {
			tp_error_validPassword.setVisible(false);
			tp_error_password.setVisible(false);
			setBorderColorAndPadding(tf_password, lineborderWhite);
		} else {
			tp_error_validPassword.setVisible(true);
			tp_error_password.setVisible(true);
			setBorderColorAndPadding(tf_password, lineborderRed);
			if (!textFields[5]) {
				tp_error_password.setText("Votre mot de passe n'est pas assez fort.");
				setBoundsIfPasswordErrors();
			}
			if (!textFields[6]) {
				tp_error_password.setText("Champ obligatoire. Saisissez votre mot de passe.");
			}
		}

		// checkPasswordConfirm
		if (textFields[7] & textFields[8]) {
			tp_error_confirmPsw.setVisible(false);
			setBorderColorAndPadding(tf_confirmPsw, lineborderWhite);
		} else {
			tp_error_confirmPsw.setVisible(true);
			setBorderColorAndPadding(tf_confirmPsw, lineborderRed);
			if (!textFields[7]) {
				tp_error_confirmPsw.setText("La confirmation de votre mot de passe n'est pas valide.");
			}
			if (!textFields[8]) {
				tp_error_confirmPsw.setText("Champ obligatoire. Confirmez votre mot de passe.");
			}
		}

	}

	/**
	 * Encrypts the password
	 * 
	 * @param String password
	 * @return the password encrypted (String)
	 */
	public static String cryptPswd(String password) {
		String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
		return hashed;
	}

	/**
	 * Changes the position of the elements for the display of the password error
	 */
	public static void setBoundsIfPasswordErrors() {
		Main.getFormSubscribe().setBounds(100, 100, 634, 775);
		Main.getFormSubscribe().setLocationRelativeTo(null);
		pl_subscribe.setBounds(0, 0, 619, 595);
		pl_br.setBounds(43, 673, 535, 1);
		lbl_alreadyRegistered.setBounds(43, 690, 108, 30);
		btn_login.setBounds(159, 690, 180, 30);
	}

	/**
	 * Changes the position of the elements for the display of the password error
	 */
	public static void setBoundsIfNoErrors() {
		Main.getFormSubscribe().setBounds(100, 100, 634, 649);
		Main.getFormSubscribe().setLocationRelativeTo(null);
		pl_br.setBounds(43, 550, 535, 1);
		lbl_alreadyRegistered.setBounds(43, 565, 108, 30);
		btn_login.setBounds(159, 565, 180, 30);
	}

	/**
	 * 
	 */
	public static void setBorderColorAndPadding(JTextField jTexField, Border border) {
		jTexField.setBorder(border);
		jTexField.setBorder(
				BorderFactory.createCompoundBorder(jTexField.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
	}

	/**
	 * 
	 */
	public static void resetFields() {
		tf_nickname.setText("");
		tf_email.setText("");
		tf_name.setText("");
		tf_firstname.setText("");
		tf_city.setText("");
		tf_password.setText("");
		tf_confirmPsw.setText("");
		tp_error_nickname.setVisible(false);
		tp_error_email.setVisible(false);
		tp_error_validPassword.setVisible(false);
		tp_error_confirmPsw.setVisible(false);
		tp_error_password.setVisible(false);
		setBorderColorAndPadding(tf_nickname, lineborderWhite);
		setBorderColorAndPadding(tf_email, lineborderWhite);
		setBorderColorAndPadding(tf_password, lineborderWhite);
		setBorderColorAndPadding(tf_confirmPsw, lineborderWhite);
	}

	/**
	 * @return the tf_password
	 */
	public static JPasswordField getTf_password() {
		return tf_password;
	}

	/**
	 * @param tf_password the tf_password to set
	 */
	public static void setTf_password(JPasswordField tf_password) {
		FormRegistration.tf_password = tf_password;
	}

	/**
	 * @return the tf_confirmPsw
	 */
	public static JPasswordField getTf_confirmPsw() {
		return tf_confirmPsw;
	}

	/**
	 * @param tf_confirmPsw the tf_confirmPsw to set
	 */
	public static void setTf_confirmPsw(JPasswordField tf_confirmPsw) {
		FormRegistration.tf_confirmPsw = tf_confirmPsw;
	}

	/**
	 * @return the tf_nickname
	 */
	public static JTextField getTf_nickname() {
		return tf_nickname;
	}

	/**
	 * @param tf_nickname the tf_nickname to set
	 */
	public static void setTf_nickname(JTextField tf_nickname) {
		FormRegistration.tf_nickname = tf_nickname;
	}

	/**
	 * @return the tf_email
	 */
	public static JTextField getTf_email() {
		return tf_email;
	}

	/**
	 * @param tf_email the tf_email to set
	 */
	public static void setTf_email(JTextField tf_email) {
		FormRegistration.tf_email = tf_email;
	}

	/**
	 * @return the tf_name
	 */
	public static JTextField getTf_name() {
		return tf_name;
	}

	/**
	 * @param tf_name the tf_name to set
	 */
	public static void setTf_name(JTextField tf_name) {
		FormRegistration.tf_name = tf_name;
	}

	/**
	 * @return the tf_firstname
	 */
	public static JTextField getTf_firstname() {
		return tf_firstname;
	}

	/**
	 * @param tf_firstname the tf_firstname to set
	 */
	public static void setTf_firstname(JTextField tf_firstname) {
		FormRegistration.tf_firstname = tf_firstname;
	}

	/**
	 * @return the tf_city
	 */
	public static JTextField getTf_city() {
		return tf_city;
	}

	/**
	 * @param tf_city the tf_city to set
	 */
	public static void setTf_city(JTextField tf_city) {
		FormRegistration.tf_city = tf_city;
	}

}