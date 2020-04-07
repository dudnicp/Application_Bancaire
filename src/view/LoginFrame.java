package view;


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

import controller.Controller;
import model.InvalidPasswordException;
import model.InvalidUserException;

public class LoginFrame extends JFrame {
	private static final long serialVersionUID = -2050486294034364666L;
	
	private Controller controller;
	
	private final JLabel idLabel = new JLabel("User ID: ");
	private final JLabel passwordLabel = new JLabel("Password: ");
	private JTextField idField;
	private JPasswordField passwordField;
	private JButton loginButton;
	
	
	public LoginFrame(Controller controller) {
		this.controller = controller;
		
		this.setTitle("Bank-App");
		this.setSize(new Dimension(500, 300));
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
	
	public void login() {
		try {
			controller.validateLogin(idField.getText(), passwordField.getText());
			JOptionPane.showMessageDialog(null, "Welcome to the Bank-App!", null, JOptionPane.INFORMATION_MESSAGE);
			dispose();
			
			/* Place holder */
			JFrame appFrame = new JFrame();
			appFrame.setTitle("Bank-App");
			appFrame.setSize(new Dimension(1000, 600));
			appFrame.setResizable(false);
			appFrame.setLocationRelativeTo(null);
			appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			appFrame.setVisible(true);
			
		} catch (InvalidUserException e2) {
			JOptionPane.showMessageDialog(null, "User not found", "Error", JOptionPane.ERROR_MESSAGE);
			reset();
		} catch (InvalidPasswordException e2) {
			JOptionPane.showMessageDialog(null, "Invalid password", "Error", JOptionPane.ERROR_MESSAGE);
			passwordField.setText(null);
		}
	}
	
	class LoginButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			login();
		}
	}
	
	class KeyLoginListener implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_ENTER:
				login();
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
}

