package view;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DataChangeView extends JDialog {

	private static final long serialVersionUID = 1082128310085972181L;
	
	private JTextField newDataField = new JTextField(20);
	private JTextField confirmDataField = new JTextField(20);
	private JPasswordField passwordField = new JPasswordField(20);
	private JButton confirmButton = new JButton("Confirmer");
	private JButton annulButton = new JButton("Annuler");
	private String whatToChange;
	private String newString;
	
	public DataChangeView(JFrame parent, String title, boolean modal, String whatToChange, boolean feminin) {
		this.setTitle(title);
		this.setResizable(false);
		this.whatToChange = whatToChange;
		this.newString = feminin? "Nouvelle " : "Nouveau ";
		
		JPanel contentPane = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridwidth = 1;
		c.gridwidth = 1;
		c.ipadx = 0;
		c.ipady = 5;
		
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(40,20,10,10);
		c.anchor = GridBagConstraints.LINE_END;
		contentPane.add(new JLabel("Entrez code secret"), c);
		
		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(40,0,10,20);
		c.anchor = GridBagConstraints.CENTER;
		contentPane.add(passwordField, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(0,20,10,10);
		c.anchor = GridBagConstraints.LINE_END;
		contentPane.add(new JLabel(newString + whatToChange), c);
		
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(0,0,10,20);
		c.anchor = GridBagConstraints.CENTER;
		contentPane.add(newDataField, c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(0,20,10,10);
		c.anchor = GridBagConstraints.LINE_END;
		contentPane.add(new JLabel("Confirmez " + newString.toLowerCase() + whatToChange), c);
		
		c.gridx = 1;
		c.gridy = 2;
		c.insets = new Insets(0,0,10,20);
		c.anchor = GridBagConstraints.CENTER;
		contentPane.add(confirmDataField, c);
		
		c.ipady = 0;
		c.ipadx = 0;
		
		c.gridx = 0;
		c.gridy = 3;
		c.anchor = GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 20, 40, 0);
		contentPane.add(annulButton, c);
		
		c.gridx = 1;
		c.gridy = 3;
		c.ipadx = 0;
		c.anchor = GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 0, 40, 20);
		contentPane.add(confirmButton, c);
		
		
		this.setContentPane(contentPane);
		this.pack();
		this.setLocationRelativeTo(null);
	}
	
	public void setWhatToChange(String whatToChange) {
		this.whatToChange = whatToChange;
	}
	
	@SuppressWarnings("deprecation")
	public String[] getFields() {
		String[] retTab = new String[3];
		retTab[0] = passwordField.getText();
		retTab[1] = newDataField.getText();
		retTab[2] = confirmDataField.getText();
		
		return retTab;
	}
	
	public String getNewDataFieldText() {
		return newDataField.getText();
	}
	
	public String getConfirmDataFieldText() {
		return confirmDataField.getText();
	}
	
	@SuppressWarnings("deprecation")
	public String getPasswordFieldText() {
		return passwordField.getText();
	}
	
	public void addConfirmButtonListener(ActionListener l) {
		confirmButton.addActionListener(l);
	}
	
	public void addAnnulButtonListener(ActionListener l) {
		annulButton.addActionListener(l);
	}
	
	public void resetFields() {
		passwordField.setText("");
		newDataField.setText("");
		confirmDataField.setText("");
	}

	
	public void displayInvalidPasswordError() {
		JOptionPane.showMessageDialog(null, "Mot de passe invalide.", "Erreur", 
						JOptionPane.ERROR_MESSAGE);
		resetFields();
	}
	
	public void displayNonMatchingFieldsError() {
		JOptionPane.showMessageDialog(null, "Les deux " + whatToChange + "s entrés ne correspondent pas.", "Erreur", 
				JOptionPane.ERROR_MESSAGE);
		resetFields();
	}
	
	public void displayCustomError(String str) {
		JOptionPane.showMessageDialog(null, str, "Erreur", JOptionPane.ERROR_MESSAGE);
		resetFields();
	}
	
	public void displaySucessfulModificationMessage() {
		JOptionPane.showMessageDialog(null, newString + whatToChange + " enregistré.", null, 
				JOptionPane.INFORMATION_MESSAGE);
	}
}
