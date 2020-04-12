package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends JFrame {
	
	private static final long serialVersionUID = 1554749051379293115L;

	private JTextField idField;
	private JPasswordField passwordField;	
	private JButton loginButton;
	
	public LoginView() {
		this.setTitle("Bank-App");
		this.setSize(300,200);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.idField = new JTextField(12);
		this.passwordField = new JPasswordField(12);
		loginButton = new JButton("Login");
		

		JPanel panel = new JPanel();
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
		panel.add(new JLabel("Code client: "), c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.anchor = GridBagConstraints.LINE_END;
		panel.add(new JLabel("Code secret: "), c);
		
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
		
		this.setContentPane(panel);
	}
	
	public String getEnteredId() {
		return idField.getText();
	}
	
	@SuppressWarnings("deprecation")
	public String getEnteredPassword() {
		return passwordField.getText();
	}
	
	
	public void resetId() {
		idField.setText("");
	}
	
	public void resetPassword() {
		passwordField.setText("");
	}

	
	public void displayInvalidUserError() {
		JOptionPane.showMessageDialog(null, "Utilisateur inconnu.", "Erreur", 
						JOptionPane.ERROR_MESSAGE);
		resetId();
		resetPassword();
	}
	
	public void displayInvalidPasswordError() {
		JOptionPane.showMessageDialog(null, "Mot de passe invalide.", "Erreur", 
						JOptionPane.ERROR_MESSAGE);
		resetPassword();
	}
	
	public void displayWelcomeMessage(String userPersonalData) {
		String welcomeMessage = "Connécté en tant que " 
				+ userPersonalData;
		JOptionPane.showMessageDialog(null, welcomeMessage, "Bienvenue!", 
							JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void addLoginListener(ActionListener buttonListener, KeyListener keyListener) {
		idField.addKeyListener(keyListener);
		passwordField.addKeyListener(keyListener);
		loginButton.addActionListener(buttonListener);
	}
}
