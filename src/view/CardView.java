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


public class CardView extends ContentView {
	
	private static final long serialVersionUID = 8856070653088403069L;
	
	private JButton button = new JButton();
	private JLabel[] labels = new JLabel[3];
	
	public CardView() {
		
		this.setPreferredSize(new Dimension(385, 70));
		this.setMaximumSize(new Dimension(385, 70));
		
		this.setLayout(new GridBagLayout());
		this.setBorder(BorderFactory.createRaisedBevelBorder());
		GridBagConstraints c = new GridBagConstraints();
		
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel();
		}
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(10, 10, 5, 20);
		c.anchor = GridBagConstraints.LINE_START;
		this.add(labels[0], c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(0, 10, 10, 0);
		this.add(labels[1], c);
		
		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(10, 0, 0, 10);
		c.anchor = GridBagConstraints.LINE_END;
		this.add(labels[2], c);
		
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(0, 0, 10, 10);
		this.add(button, c);
	}
	
	public void setLabelText(int index, String text) {
		labels[index].setText(text);
	}
	
	public void setLabelFont(int index, Font font) {
		labels[index].setFont(font);
	}
	
	public void setButtonText(String text) {
		button.setText(text);
	}
	
	public void addButtonListener(ActionListener l) {
		button.addActionListener(l);
	}
}
