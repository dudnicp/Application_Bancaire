package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

public class PreferencesView extends ContentView {

	private static final long serialVersionUID = 4201335039425890796L;
	private JLabel[] labels = new JLabel[6];
	private JButton[] buttons = new JButton[4];
	
	public PreferencesView() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel();
		}
		
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
		}
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(40, 0, 0, 40);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.LINE_START;
		this.add(labels[0], c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.gridheight = 1;
		c.insets = new Insets(10, 0, 20, 40);
		this.add(labels[1], c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(10, 0, 00, 40);
		this.add(labels[2], c);
		
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.gridheight = 1;
		c.insets = new Insets(10, 0, 20, 40);
		this.add(labels[3], c);
		
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(10, 0, 00, 40);
		this.add(labels[4], c);
		
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.gridheight = 1;
		c.insets = new Insets(10, 0, 20, 40);
		this.add(labels[5], c);
		
		
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.gridheight = 1;
		c.insets = new Insets(40, 0, 0, 40);
		this.add(buttons[0], c);
		
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.gridheight = 1;
		c.insets = new Insets(10, 0, 0, 40);
		this.add(buttons[1], c);
		
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.gridheight = 1;
		this.add(buttons[2], c);
		
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.gridheight = 1;
		this.add(buttons[3], c);
	}
	
	public void setLabelText(int index, String text) {
		labels[index].setText(text);
	}
	
	public void setLabelFont(int index, Font font) {
		labels[index].setFont(font);
	}
	
	public void setButtonText(int index, String text) {
		buttons[index].setText(text);
	}
	
	public void addButtonAction(int index, ActionListener action) {
		buttons[index].addActionListener(action);
	}
}
