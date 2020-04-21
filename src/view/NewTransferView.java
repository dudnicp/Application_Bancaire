package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewTransferView extends ContentView {

	private static final long serialVersionUID = -6633830137904266604L;
	
	private JLabel[] mainLabels = new JLabel[2];
	private JComboBox<Object> optionBox = new JComboBox<Object>();
	private JTextField  textField = new JTextField(10);
	private JButton button = new JButton();
	private JCheckBox checkBox = new JCheckBox();
	
	private JPanel auxPanel = new JPanel();
	private JLabel[] auxLabels = new JLabel[2];
	private JTextField[] auxFields = new JTextField[3];
	private JComboBox<Object> auxOptionBox = new JComboBox<Object>();
	
	public NewTransferView() {
		
		this.setPreferredSize(new Dimension(420, 300));
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		for (int i = 0; i < mainLabels.length; i++) {
			mainLabels[i] = new JLabel();
		}
		
		for (int i = 0; i < auxLabels.length; i++) {
			auxLabels[i] = new JLabel();
		}
		
		for (int i = 0; i < auxFields.length; i++) {
			auxFields[i] = new JTextField(4);
		}
		
		c.ipady = 10;
		c.insets = new Insets(3, 0, 3, 0);
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.anchor = GridBagConstraints.LINE_END;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(mainLabels[0], c);
		
		c.gridx = 1;
		c.gridy = 0;
		c.anchor = GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.NONE;
		this.add(optionBox, c);
		
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		this.add(button, c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_END;
		c.insets = new Insets(10, 0, 0, 0);
		this.add(mainLabels[1], c);
		
		c.gridx = 1;
		c.gridy = 2;
		c.anchor = GridBagConstraints.LINE_START;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(textField, c);
		
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 2;
		c.insets = new Insets(3, 0, 3, 0);
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.CENTER;
		this.add(checkBox, c);
		
		
		auxPanel.setLayout(new GridBagLayout());
		
		c.ipadx = 0;
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(3, 0, 3, 0);
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_END;
		auxPanel.add(auxLabels[0], c);
		
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.anchor = GridBagConstraints.CENTER;
		auxPanel.add(auxOptionBox, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		auxPanel.add(auxLabels[1], c);


		Box box = Box.createHorizontalBox();
		box.add(auxFields[0]);
		box.add(new JLabel(" - "));
		box.add(auxFields[1]);
		box.add(new JLabel(" - "));
		box.add(auxFields[2]);
		
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 2;
		auxPanel.add(box, c);
		
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.ipadx = 0;
		c.anchor = GridBagConstraints.CENTER;
		this.add(auxPanel, c);
		
		auxPanel.setVisible(false);
	}
	
	public void setCheckBoxText(String text) {
		checkBox.setText(text);
	}
	
	public void setMainLabelText(int index, String text) {
		mainLabels[index].setText(text);
	}
	
	public void setMainLabelFont(int index, Font font) {
		mainLabels[index].setFont(font);
	}
	
	public void setButtonText(String text) {
		button.setText(text);
	}
	
	public void addButtonAction(ActionListener l) {
		button.addActionListener(l);
	}
	
	public void addOption(Object obj) {
		optionBox.addItem(obj);
	}
	
	public Object getSelectedOption() {
		return optionBox.getSelectedItem();
	}
	
	public String getTextField() {
		return textField.getText();
	}
	
	public boolean isCheckBoxChecked() {
		return checkBox.isSelected();
	}
	
	public void showAuxContent() {
		auxPanel.setVisible(true);
	}
	
	public void hideAuxContent() {
		auxPanel.setVisible(false);
	}
	
	public void setAuxLabelText(int index, String text) {
		auxLabels[index].setText(text);
	}
	
	public void addAuxOption(Object obj) {
		auxOptionBox.addItem(obj);
	}
	
	public Object getAuxOption() {
		return auxOptionBox.getSelectedItem();
	}
	
	
	public void addCheckBoxListener(ActionListener l) {
		checkBox.addActionListener(l);
	}
	
	
	public void setAuxOption(Object obj) {
		auxOptionBox.setSelectedItem(obj);
	}
	
	public String getAuxField(int index) {
		return auxFields[index].getText();
	}
	
	public void setAuxField(int index, String str) {
		auxFields[index].setText(str);
	}
}
