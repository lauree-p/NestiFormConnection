package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import tool.ImagePanel;

@SuppressWarnings("serial")
public class App extends JFrame {

	private AccountData panel_my_account_info;
	private AccountDataUpdate panel_my_account_update;
	private ImagePanel panel_logo;
	private JPanel panel_sidebar, panel_sidebar_hr, panel_title_app;
	private JButton btn_sidebar_info, btn_sidebar_update, btn_title_disco;
	private JLabel lbl_sidebar_my_account, lbl_title_my_account;
	private FormLogin formLogin;

	/**
	 * Create the frame.
	 */
	public App() {
		initialize();
		setResizable(false);
		setBounds(100, 100, 1118, 663);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		panel_logo = new ImagePanel(new ImageIcon(getClass().getResource("/img/logo.png")).getImage());
		panel_logo.setBounds(202, 11, 85, 85);
		panel_logo.setLayout(null);
		getContentPane().add(panel_logo);

		panel_title_app = new JPanel();
		panel_title_app.setBounds(0, 24, 1112, 48);
		panel_title_app.setBackground(new Color(191, 163, 124));
		getContentPane().add(panel_title_app);
		panel_title_app.setLayout(null);

		btn_title_disco = new JButton("DECONNEXION");
		btn_title_disco.setForeground(Color.WHITE);
		btn_title_disco.setFont(new Font("Montserrat", Font.PLAIN, 12));
		btn_title_disco.setBounds(957, 14, 132, 23);
		btn_title_disco.setBackground(new Color(191, 163, 124));
		btn_title_disco.setFocusable(false);
		btn_title_disco.setBorder(BorderFactory.createLineBorder(new Color(67,46,46), 1));
		panel_title_app.add(btn_title_disco);

		lbl_title_my_account = new JLabel("MON COMPTE");
		lbl_title_my_account.setForeground(Color.WHITE);
		lbl_title_my_account.setFont(new Font("Montserrat", Font.BOLD, 12));
		lbl_title_my_account.setBounds(832, 14, 106, 23);
		panel_title_app.add(lbl_title_my_account);

		panel_sidebar = new JPanel();
		panel_sidebar.setBackground(new Color(84, 62, 56));
		panel_sidebar.setBounds(0, 0, 202, 634);
		getContentPane().add(panel_sidebar);
		panel_sidebar.setLayout(null);

		lbl_sidebar_my_account = new JLabel("MON COMPTE");
		lbl_sidebar_my_account.setForeground(Color.WHITE);
		lbl_sidebar_my_account.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_sidebar_my_account.setFont(new Font("Montserrat", Font.BOLD, 14));
		lbl_sidebar_my_account.setBounds(20, 186, 172, 26);
		panel_sidebar.add(lbl_sidebar_my_account);

		btn_sidebar_info = new JButton("Information détaillés");
		btn_sidebar_info.setForeground(Color.WHITE);
		btn_sidebar_info.setBackground(new Color(84, 62, 56));
		btn_sidebar_info.setFont(new Font("Montserrat", Font.BOLD, 12));
		btn_sidebar_info.setBounds(10, 227, 182, 23);
		btn_sidebar_info.setFocusable(false);
		btn_sidebar_info.setBorder(BorderFactory.createLineBorder(new Color(67,46,46), 1));
		panel_sidebar.add(btn_sidebar_info);

		btn_sidebar_update = new JButton("Modifier mon compte");
		btn_sidebar_update.setForeground(Color.WHITE);
		btn_sidebar_update.setBackground(new Color(84, 62, 56));
		btn_sidebar_update.setFont(new Font("Montserrat", Font.PLAIN, 12));
		btn_sidebar_update.setBounds(10, 261, 182, 23);
		btn_sidebar_update.setFocusable(false);
		btn_sidebar_update.setBorder(BorderFactory.createLineBorder(new Color(67,46,46), 1));
		panel_sidebar.add(btn_sidebar_update);

		panel_sidebar_hr = new JPanel();
		panel_sidebar_hr.setBounds(10, 215, 182, 1);
		panel_sidebar.add(panel_sidebar_hr);

		panel_my_account_info = new AccountData();
		getContentPane().add(panel_my_account_info);

		panel_my_account_update = new AccountDataUpdate();
		getContentPane().add(panel_my_account_update);

		// Actions Listener

		btn_sidebar_update.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				System.out.println("Clique sur modifier mon compte");
				panel_my_account_info.setVisible(false);
				panel_my_account_update.setVisible(true);
				btn_sidebar_info.setFont(new Font("Montserrat", Font.PLAIN, 12));
				btn_sidebar_update.setFont(new Font("Montserrat", Font.BOLD, 12));
			}
		});

		btn_sidebar_info.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				System.out.println("Clique sur information détaillé");
				panel_my_account_info.setVisible(true);
				panel_my_account_update.setVisible(false);
				btn_sidebar_info.setFont(new Font("Montserrat", Font.BOLD, 12));
				btn_sidebar_update.setFont(new Font("Montserrat", Font.PLAIN, 12));

			}
		});
		
		btn_title_disco.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				setFormLogin(new FormLogin());

			}
		});
	}
	
	// Getters & Setters

	/**
	 * @return the panel_my_account_info
	 */
	public AccountData getPanel_my_account_info() {
		return panel_my_account_info;
	}

	/**
	 * @param panel_my_account_info the panel_my_account_info to set
	 */
	public void setPanel_my_account_info(AccountData panel_my_account_info) {
		this.panel_my_account_info = panel_my_account_info;
	}

	/**
	 * @return the panel_my_account_update
	 */
	public AccountDataUpdate getPanel_my_account_update() {
		return panel_my_account_update;
	}

	/**
	 * @param panel_my_account_update the panel_my_account_update to set
	 */
	public void setPanel_my_account_update(AccountDataUpdate panel_my_account_update) {
		this.panel_my_account_update = panel_my_account_update;
	}

	/**
	 * @return the formLogin
	 */
	public FormLogin getFormLogin() {
		return formLogin;
	}

	/**
	 * @param formLogin the formLogin to set
	 */
	public void setFormLogin(FormLogin formLogin) {
		this.formLogin = formLogin;
	}

}
