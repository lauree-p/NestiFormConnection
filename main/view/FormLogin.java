package view;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import controller.Login;
import controller.LoginImpl;
import main.Main;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import tool.ImagePanel;

import javax.swing.JTextPane;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class FormLogin extends JFrame {

	private static JTextField tf_username;
	private static JTextPane txtpn_error_login;
	private static Font fontTextField = new Font("Montserrat", Font.PLAIN, 12);
	private static JPasswordField pf_password;
	private static Border lineborderWhite = BorderFactory.createLineBorder(Color.white, 1);
	private static Border lineborderRed = BorderFactory.createLineBorder(Color.red, 1);
	private static ImagePanel pl_logo;
	private static JPanel pl_title_login, pl_br, pl_login;
	private static JLabel lbl_subscribe, lbl_always_subscribe, lbl_usename, lbl_password;
	private static JButton btn_login, btn_cancel, btn_create_account;

	public FormLogin() {
		initialize();
		setBounds(100, 100, 635, 393);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setFocusable(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		pl_login = new JPanel();
		pl_login.setBackground(new Color(67, 46, 46));
		pl_login.setBounds(0, 0, 619, 354);
		pl_login.setLayout(null);
		getContentPane().add(pl_login);

		pl_logo = new ImagePanel(new ImageIcon(getClass().getResource("/img/logo.png")).getImage());
		pl_logo.setBounds(159, 11, 85, 85);
		pl_logo.setLayout(null);
		pl_login.add(pl_logo);

		pl_title_login = new JPanel();
		pl_title_login.setBounds(0, 24, 619, 48);
		pl_title_login.setBackground(new Color(191, 163, 124));
		pl_title_login.setLayout(null);
		pl_login.add(pl_title_login);

		pl_br = new JPanel();
		pl_br.setBorder(new CompoundBorder());
		pl_br.setBounds(44, 291, 535, 1);
		pl_login.add(pl_br);

		lbl_subscribe = new JLabel("CONNEXION");
		lbl_subscribe.setForeground(Color.WHITE);
		lbl_subscribe.setFont(new Font("Montserrat", Font.BOLD, 12));
		lbl_subscribe.setBounds(262, 0, 122, 48);
		pl_title_login.add(lbl_subscribe);

		lbl_always_subscribe = new JLabel("Pas encore de compte Nesti ?");
		lbl_always_subscribe.setFont(new Font("Montserrat", Font.BOLD, 12));
		lbl_always_subscribe.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_always_subscribe.setForeground(Color.WHITE);
		lbl_always_subscribe.setBounds(44, 309, 208, 30);
		pl_login.add(lbl_always_subscribe);

		lbl_usename = new JLabel("COMPTE");
		lbl_usename.setFont(new Font("Montserrat", Font.PLAIN, 13));
		lbl_usename.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_usename.setForeground(Color.WHITE);
		lbl_usename.setBounds(0, 130, 149, 14);
		pl_login.add(lbl_usename);

		lbl_password = new JLabel("MOT DE PASSE");
		lbl_password.setFont(new Font("Montserrat", Font.PLAIN, 13));
		lbl_password.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_password.setForeground(Color.WHITE);
		lbl_password.setBounds(0, 177, 149, 23);
		pl_login.add(lbl_password);

		tf_username = new JTextField();
		tf_username.setBounds(159, 120, 385, 30);
		tf_username.setColumns(10);
		tf_username.setBackground(new Color(67, 46, 46));
		tf_username.setForeground(Color.WHITE);
		setBorderTf(lineborderWhite);
		tf_username.setFont(fontTextField);
		tf_username.setCaretColor(Color.WHITE);
		tf_username.requestFocus();
		pl_login.add(tf_username);

		btn_login = new JButton("SE CONNECTER");
		btn_login.setFont(new Font("Montserrat", Font.PLAIN, 11));
		btn_login.setHorizontalAlignment(SwingConstants.LEFT);
		btn_login.setBounds(159, 240, 215, 30);
		btn_login.setBackground(new Color(85, 65, 65));
		btn_login.setForeground(Color.WHITE);
		btn_login.setBorderPainted(false);
		btn_login.setFocusable(false);
		pl_login.add(btn_login);

		btn_cancel = new JButton("ANNULER");
		btn_cancel.setHorizontalAlignment(SwingConstants.LEFT);
		btn_cancel.setFont(new Font("Montserrat", Font.PLAIN, 11));
		btn_cancel.setBounds(406, 240, 138, 29);
		btn_cancel.setBackground(new Color(191, 163, 124));
		btn_cancel.setForeground(Color.WHITE);
		btn_cancel.setBorderPainted(false);
		btn_cancel.setFocusable(false);
		pl_login.add(btn_cancel);

		btn_create_account = new JButton("CREER UN COMPTE ...");
		btn_create_account.setFont(new Font("Montserrat", Font.PLAIN, 11));
		btn_create_account.setHorizontalAlignment(SwingConstants.LEFT);
		btn_create_account.setBounds(248, 308, 208, 30);
		btn_create_account.setBackground(new Color(85, 65, 65));
		btn_create_account.setForeground(Color.WHITE);
		btn_create_account.setBorderPainted(false);
		btn_create_account.setFocusable(false);
		pl_login.add(btn_create_account);

		txtpn_error_login = new JTextPane();
		txtpn_error_login.setFont(new Font("Montserrat", Font.PLAIN, 10));
		txtpn_error_login.setBounds(159, 205, 385, 32);
		txtpn_error_login.setBackground(new Color(67, 46, 46));
		txtpn_error_login.setForeground(Color.WHITE);
		setPaddingTp();
		txtpn_error_login.setVisible(false);
		pl_login.add(txtpn_error_login);

		pf_password = new JPasswordField();
		pf_password.setBounds(159, 170, 385, 30);
		pf_password.setBackground(new Color(67, 46, 46));
		pf_password.setForeground(Color.WHITE);
		setBorderPf(lineborderWhite);
		pf_password.setFont(fontTextField);
		pf_password.setCaretColor(Color.WHITE);
		pf_password.requestFocus();
		pl_login.add(pf_password);

		// ---- JButton Event

		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetErrorsFields();
			}
		});

		btn_create_account.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetErrorsFields();
				Main.getFormLogin().setVisible(false);
				Main.getFormSubscribe().setVisible(true);
				Main.getFormSubscribe().setLocationRelativeTo(null);
			}
		});

		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connectUser();
			}
		});

		/**
		 * Press ENTER for login
		 */
		KeyListener listener = new KeyListener() {
			public void keyPressed(KeyEvent event) {
			}

			public void keyReleased(KeyEvent event) {
			}

			public void keyTyped(KeyEvent event) {
				if (event.getKeyChar() == KeyEvent.VK_ENTER) {
					loginUserKey(event);
				}
			}

			public void loginUserKey(KeyEvent event) {
				if (event.getKeyChar() == KeyEvent.VK_ENTER) {
					connectUser();
					event.consume();
				}
			}
		};

		addKeyListener(listener);
		tf_username.addKeyListener(listener);
		pf_password.addKeyListener(listener);

	}

	/**
	 * Connect the user if the username and password are valid
	 */
	public static void connectUser() {
		Login login = new LoginImpl();
		
		if (login.fieldsNotEmpty()) {
			if (login.findUser() != null) {
				if (login.checkPasswordwithUsername()) {
					displayConnectUser();
				} else {
					displayErrorWrongPswd();
				}
			} else {
				displayErrorNoUserFind();
			}
		} else {
			if (login.fieldUsernameNotEmpty()) {
				if (login.findUser() != null) {
					displayErrorPswdEmpty();
				} else {
					displayErrorEmptyFields();
				}
			} else {
				displayErrorEmptyFields();
			}
		}
	}

	public static void displayErrorEmptyFields() {
		txtpn_error_login.setVisible(true);
		setBorderPf(lineborderRed);
		setBorderTf(lineborderRed);
		txtpn_error_login.setText("Veuillez saisir votre nom d'utilisateur ou email et votre mot de passe.");
	}

	public static void displayErrorNoUserFind() {
		txtpn_error_login.setVisible(true);
		setBorderPf(lineborderRed);
		setBorderTf(lineborderRed);
		txtpn_error_login.setText("Aucun compte trouvé avec ce compte utilisateur.");
	}

	public static void displayErrorWrongPswd() {
		txtpn_error_login.setVisible(true);
		setBorderPf(lineborderRed);
		txtpn_error_login.setText("Mot de passe incorrect.");
	}

	public static void displayErrorPswdEmpty() {
		txtpn_error_login.setVisible(true);
		setBorderPf(lineborderRed);
		setBorderTf(lineborderWhite);
		txtpn_error_login.setText("Veuillez saisir votre mot de passe.");
	}

	public static void setBorderPf(Border border) {
		pf_password.setBorder(border);
		pf_password.setBorder(BorderFactory.createCompoundBorder(pf_password.getBorder(),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
	}

	public static void setBorderTf(Border border) {
		tf_username.setBorder(border);
		tf_username.setBorder(BorderFactory.createCompoundBorder(tf_username.getBorder(),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
	}

	public static void setPaddingTp() {
		txtpn_error_login.setBorder(BorderFactory.createCompoundBorder(txtpn_error_login.getBorder(),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
	}

	public static void displayConnectUser() {
		Login login = new LoginImpl();
		getTxtpn_error_login().setVisible(false);
		Main.getFormLogin().setVisible(false);
		App nestiApp = new App();
		nestiApp.setVisible(true);
		App.setUserConnected(login.findUser());
	}

	public static void resetErrorsFields() {
		txtpn_error_login.setVisible(false);
		tf_username.setText("");
		pf_password.setText("");
		setBorderTf(lineborderWhite);
		setBorderPf(lineborderWhite);
	}


	/**
	 * @return the pf_password
	 */
	public static JPasswordField getPf_password() {
		return FormLogin.pf_password;
	}

	/**
	 * @param pf_password the pf_password to set
	 */
	public void setPf_password(JPasswordField pf_password) {
		FormLogin.pf_password = pf_password;
	}

	/**
	 * @return the tf_username
	 */
	public static JTextField getTf_username() {
		return FormLogin.tf_username;
	}

	/**
	 * @param tf_username the tf_username to set
	 */
	public void setTf_username(JTextField tf_username) {
		FormLogin.tf_username = tf_username;
	}

	/**
	 * @return the txtpn_error_login
	 */
	public static JTextPane getTxtpn_error_login() {
		return txtpn_error_login;
	}

	/**
	 * @param txtpn_error_login the txtpn_error_login to set
	 */
	public void setTxtpn_error_login(JTextPane txtpn_error_login) {
		FormLogin.txtpn_error_login = txtpn_error_login;
	}

}