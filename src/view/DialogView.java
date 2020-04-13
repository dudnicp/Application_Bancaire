package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class DialogView {
	
	public static void displayInfoDialog(String msg, String title) {
		JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static int getIntOption(String msg, String title) {
		return JOptionPane.showConfirmDialog(null, msg, title,
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	}
	
	
	
	public static String getStringOption(String msg, String title) {
		return JOptionPane.showInputDialog(null, msg, title, JOptionPane.QUESTION_MESSAGE);
	}
	
	public static Object getOptionFromList(ArrayList<? extends Object> options, String msg, String title) {
		return JOptionPane.showInputDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE, 
							null, options.toArray(), options.toArray()[0]);
	}
	
	public static String askPassword() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Code Secret: ");
		JPasswordField pass = new JPasswordField(15);
		panel.add(label);
		panel.add(pass);
		String[] options = new String[]{"Confirmer", "Cancel"};
		int option = JOptionPane.showOptionDialog(null, panel, "Confirmation",
		                         JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
		                         null, options, options[0]);
		if(option == JOptionPane.OK_OPTION) // pressing OK button
		{
		    char[] password = pass.getPassword();
		    return new String(password);
		}
		return null;
	}
	
	public static String[] getDoubleStringOption(String msg1, String msg2, String title, boolean hide1, boolean hide2) {
		
		
		
		JPanel panel = new JPanel();
		JTextField field1 = new JTextField(15);
		JTextField field2 = new JTextField(15);
		JPasswordField pass1 = new JPasswordField(15);
		JPasswordField pass2 = new JPasswordField(15);
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.ipadx = 0;
		c.ipady = 5;
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.anchor = GridBagConstraints.LINE_END;
		panel.add(new JLabel(msg1), c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.anchor = GridBagConstraints.LINE_END;
		panel.add(new JLabel(msg2), c);
		
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		if (hide1) {
			panel.add(pass1, c);
		} else {
			panel.add(field1, c);
		}
		
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		if (hide2) {
			panel.add(pass2, c);
		} else {
			panel.add(field2, c);
		}
		
		String[] options = new String[]{"Confirmer", "Annuler"};
		int option = JOptionPane.showOptionDialog(null, panel, title,
		                         JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
		                         null, options, options[0]);
		if(option == JOptionPane.OK_OPTION) // pressing OK button
		{
			String[] pair = new String[2];
			pair[0] = new String();
			pair[1] = new String();
			pair[0] = hide1? new String(pass1.getPassword()) : field1.getText();
			pair[1] = hide2? new String(pass2.getPassword()) : field2.getText();
			return pair;
			
		}
		return null;
	}
	
	public static void displayError(String str) {
		JOptionPane.showMessageDialog(null, str, "Erreur", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void displayModificationSuccessMessage() {
		displayInfoDialog("Modification enregistrée avec succès.", null);
	}
}
