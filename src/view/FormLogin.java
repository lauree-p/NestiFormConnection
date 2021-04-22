package view;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import controller.FormValidation;
import entity.User;
import main.Main;
import model.QueryUser;
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
import tool.BCrypt;
import tool.ImagePanel;

import javax.swing.JTextPane;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class FormLogin extends JFrame {

	private static JTextField tf_username;
	private static JTextPane txtpn_error_login;
	private static User userConnected;
	private static boolean isConnected;
	private static Font fontTextField = new Font("Montserrat", Font.PLAIN, 12);
	private static JPasswordField pf_password;
	private static App nestiApp;
	
	private static Border lineborderRed = BorderFactory.createLineBorder(Color.red, 1);
	private static Border lineborderWhite = BorderFactory.createLineBorder(Color.white, 1);
	private ImagePanel pl_logo;
	private JPanel pl_title_login, pl_br, pl_login;
	private JLabel lbl_subscribe, lbl_always_subscribe, lbl_usename, lbl_password;
	private JButton btn_login, btn_cancel, btn_create_account;

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
		tf_username.setBorder(BorderFactory.createCompoundBorder(tf_username.getBorder(),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
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
		txtpn_error_login.setBorder(BorderFactory.createCompoundBorder(txtpn_error_login.getBorder(),
				BorderFactory.createEmptyBorder(3, 3, 3, 3)));
		txtpn_error_login.setVisible(false);
		pl_login.add(txtpn_error_login);

		pf_password = new JPasswordField();
		pf_password.setBounds(159, 170, 385, 30);
		pf_password.setBackground(new Color(67, 46, 46));
		pf_password.setForeground(Color.WHITE);
		pf_password.setBorder(BorderFactory.createCompoundBorder(pf_password.getBorder(),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		pf_password.setFont(fontTextField);
		pf_password.setCaretColor(Color.WHITE);
		pf_password.requestFocus();
		pl_login.add(pf_password);

		// ---- JButton Event

		btn_cancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				txtpn_error_login.setVisible(false);
				// Reset Value
				tf_username.setText("");
				pf_password.setText("");
				
				tf_username.setBorder(lineborderWhite);
				tf_username.setBorder(BorderFactory.createCompoundBorder(tf_username.getBorder(),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)));
				pf_password.setBorder(lineborderWhite);
				pf_password.setBorder(BorderFactory.createCompoundBorder(pf_password.getBorder(),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)));
				
			}
		});

		btn_create_account.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// Reset Value
				tf_username.setText("");
				pf_password.setText("");
				
				Main.getFormLogin().setVisible(false);
				Main.getFormSubscribe().setVisible(true);
				Main.getFormSubscribe().setLocationRelativeTo(null);
				txtpn_error_login.setVisible(false);
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
		User userFind = null;
		String password = String.valueOf(pf_password.getPassword());

		// The fields are filled
		if (!tf_username.getText().equals("") & !password.equals("")) {
			// tf_username is an email
			if (FormValidation.checkValidEmail(tf_username.getText())) {
				userFind = QueryUser.findOneByEmail(tf_username.getText());
			} 
			// tf_username is an nickname
			else {
				userFind = QueryUser.findOneByNickname(tf_username.getText());
			}
			// An User exist with this email or nickname
			if (userFind.getNickname() != null & !password.equals("")) {
				// Checks if the password matches
				Boolean correctPassword = BCrypt.checkpw(password, userFind.getPassword());
				// if the password matches
				if (correctPassword) {
					setConnected(true);
					setUserConnected(userFind);
					txtpn_error_login.setVisible(false);
					Main.getFormLogin().setVisible(false);
					nestiApp = new App();
					nestiApp.setVisible(true);
				
				} 
				// if the password does not match
				else {
					txtpn_error_login.setVisible(true);
					pf_password.setBorder(lineborderRed);
					pf_password.setBorder(BorderFactory.createCompoundBorder(pf_password.getBorder(),
							BorderFactory.createEmptyBorder(5, 5, 5, 5)));
					txtpn_error_login.setText("Mot de passe incorrect.");
				}
				
			} 
			// No User exist
			else {
				txtpn_error_login.setVisible(true);
				
				pf_password.setBorder(lineborderRed);
				pf_password.setBorder(BorderFactory.createCompoundBorder(pf_password.getBorder(),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)));
				tf_username.setBorder(lineborderRed);
				tf_username.setBorder(BorderFactory.createCompoundBorder(tf_username.getBorder(),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)));
				
				txtpn_error_login.setText("Aucun compte ne correspond à votre nom d'utilisateur ou votre email.");
			}
		// The fields are not filled
		} else {
			txtpn_error_login.setVisible(true);
			pf_password.setBorder(lineborderRed);
			pf_password.setBorder(BorderFactory.createCompoundBorder(pf_password.getBorder(),
					BorderFactory.createEmptyBorder(5, 5, 5, 5)));
			tf_username.setBorder(lineborderRed);
			tf_username.setBorder(BorderFactory.createCompoundBorder(tf_username.getBorder(),
					BorderFactory.createEmptyBorder(5, 5, 5, 5)));
			txtpn_error_login.setText("Veuillez saisir votre nom d'utilisateur ou email et votre mot de passe.");
		}
	}
	
	// Getters & Setters

	/**
	 * @return the userConnected
	 */
	public static User getUserConnected() {
		return userConnected;
	}

	/**
	 * @param userConnected the userConnected to set
	 */
	public static void setUserConnected(User userConnected) {
		FormLogin.userConnected = userConnected;
	}

	/**
	 * @return the isConnected
	 */
	public static boolean isConnected() {
		return isConnected;
	}

	/**
	 * @param isConnected the isConnected to set
	 */
	public static void setConnected(boolean isConnected) {
		FormLogin.isConnected = isConnected;
	}



}