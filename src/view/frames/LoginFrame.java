package view.frames;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.LoginController;
import model.events.Event;
import model.events.LoginEvent;
import model.paterns.Observer;
import view.panels.LoginPanel;

public class LoginFrame extends JFrame implements Observer{
	private static final long serialVersionUID = -2050486294034364666L;
	
	private LoginController controller;
	
	private final JLabel idLabel = new JLabel("User ID: ");
	private final JLabel passwordLabel = new JLabel("Password: ");
	private JTextField idField;
	private JPasswordField passwordField;
	private JButton loginButton;
	
	
	public LoginFrame(LoginController controller) {
		this.controller = controller;
		
		this.setTitle("Bank-App");
		this.setSize(500,300);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.idField = new JTextField(12);
		this.idField.addKeyListener(new KeyLoginListener());
		this.passwordField = new JPasswordField(12);
		this.passwordField.addKeyListener(new KeyLoginListener());
		this.loginButton = new JButton("Login");
		loginButton.addActionListener(new LoginButtonListener());
		
		LoginPanel contentPanel = new LoginPanel();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0, 0));
		panel.setPreferredSize(new Dimension(400, 150));
		panel.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.ipadx = 0;
		c.ipady = 5;
		c.insets = new Insets(1, 0, 1, 0);
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.anchor = GridBagConstraints.LINE_END;
		panel.add(idLabel, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.anchor = GridBagConstraints.LINE_END;
		panel.add(passwordLabel, c);
		
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		panel.add(idField, c);
		
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		panel.add(passwordField, c);
		
		c.ipadx = 0;
		c.ipady = 0;
		
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		panel.add(loginButton, c);
		
		
		contentPanel.add(panel);
		
		this.setContentPane(contentPanel);
		this.setVisible(true);
	}
	
	public void reset() {
		idField.setText(null);
		passwordField.setText(null);
	}
	
	class LoginButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			controller.login(idField.getText(), passwordField.getText());
		}
	}
	
	class KeyLoginListener implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_ENTER:
				controller.login(idField.getText(), passwordField.getText());
				break;
			default:
				break;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// pass, nothing to do here
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// pass, nothing to do here
		}
	}

	@Override
	public void update(Event e) {
		LoginEvent loginEvent = (LoginEvent) e;
		switch (loginEvent.getLoginStatus()) {
		case LoginEvent.INVALID_ID:
			JOptionPane.showMessageDialog(null, "Utilisateur inconnu!", "Erreur", 
										JOptionPane.ERROR_MESSAGE);
			reset();
			break;
		case LoginEvent.INVALID_PASSWORD:
			JOptionPane.showMessageDialog(null, "Mot de passe invalide", "Erreur", 
					JOptionPane.ERROR_MESSAGE);
			passwordField.setText("");
			break;
		default:
			String welcomeMessage = "Connécté en tant que " 
							+ loginEvent.getLoggedUser().toString();
			JOptionPane.showMessageDialog(null, welcomeMessage, "Bienvenue!", 
										JOptionPane.INFORMATION_MESSAGE);
			dispose();
			break;
		}
	}
}

