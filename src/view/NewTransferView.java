package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewTransferView extends ContentView {

	private static final long serialVersionUID = -6633830137904266604L;
	
	private JLabel[] mainLabels = new JLabel[3];
	private JComboBox<Object> optionBox1 = new JComboBox<Object>();
	private JComboBox<Object> optionBox2 = new JComboBox<Object>();
	private JTextField  textField = new JTextField(10);
	private JButton button = new JButton();
	private JCheckBox checkBox = new JCheckBox();
	
	private JPanel auxPane = new JPanel();
	private JLabel[] auxLabels = new JLabel[2];
	private JComboBox<Object> auxOptionBox= new JComboBox<Object>();
	private JTextField auxTextField = new JTextField();
	
	
	public NewTransferView() {
		
		this.setPreferredSize(new Dimension(500, 500));
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		for (int i = 0; i < mainLabels.length; i++) {
			mainLabels[i] = new JLabel();
		}
		
		for (int i = 0; i < auxLabels.length; i++) {
			auxLabels[i] = new JLabel();
		}
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(mainLabels[0], c);
		
		c.gridx = 1;
		c.gridy = 0;
		this.add(optionBox1, c);
		
		
		
		c.gridx = 0;
		c.gridy = 1;
		this.add(mainLabels[1], c);
		
		c.gridx = 1;
		c.gridy = 1;
		this.add(optionBox2, c);
		
		

		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 2;
		this.add(button, c);
		
		
		
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		this.add(mainLabels[2], c);
		
		c.gridx = 1;
		c.gridy = 3;
		this.add(textField, c);
		
		
		
		c.gridx = 0;
		c.gridy = 4;
		this.add(checkBox, c);
		
		
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
	
	public void addOptionToList1(Object obj) {
		optionBox1.addItem(obj);
	}
	
	public void addOptionToList2(Object obj) {
		optionBox2.addItem(obj);
	}
	
	public Object getOption1() {
		return optionBox1.getSelectedItem();
	}
	
	public Object getOption2() {
		return optionBox1.getSelectedItem();
	}
	
	public String getTextField() {
		return textField.getText();
	}
	
	public boolean isCheckBoxChecked() {
		return checkBox.isSelected();
	}
	
	public void showAuxContent() {
		auxPane.setVisible(true);
	}
	
	public void hideAuxContent() {
		auxPane.setVisible(false);
	}
}
