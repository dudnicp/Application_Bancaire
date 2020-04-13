package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;

public class PayeeView extends ContentView {
	
	private static final long serialVersionUID = -5181276747264923888L;
	private JLabel[] labels = new JLabel[4];
	private JButton[] buttons = new JButton[2];
	
	public PayeeView() {
		
		this.setPreferredSize(new Dimension(385, 120));
		this.setMaximumSize(new Dimension(385, 120));
		this.setBorder(BorderFactory.createRaisedBevelBorder());
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel();
		}
		
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
		}
		
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(5, 0, 0, 0);
		this.add(labels[0], c);
		
		c.gridy = 1;
		c.gridwidth = 3;
		c.insets = new Insets(0, 0, 0, 0);
		this.add(labels[1], c);
		
		c.gridy = 2;
		c.gridheight = 1;
		c.insets = new Insets(15, 0, 0, 0);
		this.add(labels[2], c);
		
		
		c.gridy = 3;
		c.gridwidth = 3;
		c.insets = new Insets(5, 0, 10, 0);
		this.add(labels[3], c);
		
		c.gridx = 2;
		c.anchor = GridBagConstraints.CENTER;
		
		c.gridy = 0;
		c.gridheight = 1;
		c.gridheight = 1;
		c.insets = new Insets(0, 30, 0, 0);
		this.add(buttons[0], c);
		
		c.gridy = 2;
		this.add(buttons[1], c);
		
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
	
	public void addButtonListener(int index,ActionListener l) {
		buttons[index].addActionListener(l);
	}
}
	
