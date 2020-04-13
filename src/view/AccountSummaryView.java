package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;

public class AccountSummaryView extends HoverableAndClickableView {

	private static final long serialVersionUID = 2556846151035574506L;
	private JLabel[] labels = new JLabel[5];
	
	public AccountSummaryView() {
		
		this.setPreferredSize(new Dimension(385, 70));
		this.setMaximumSize(new Dimension(385, 70));
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel();
		}
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(10, 0, 0, 80);
		this.add(labels[0], c);
		
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = GridBagConstraints.REMAINDER;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0, 0, 0, 80);
		this.add(labels[1], c);
		
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.anchor = GridBagConstraints.LINE_END;
		c.insets = new Insets(0, 0, 0, 0);
		this.add(labels[2], c);
		
		c.gridx = 1;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(0, 0, 0, 0);
		this.add(labels[3], c);
		
		c.gridx = 1;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 1;
		this.add(labels[4], c);
		
	}
	
	public void setLabelText(int index, String text) {
		labels[index].setText(text);
	}
	
	public void setLabelFont(int index, Font font) {
		labels[index].setFont(font);
	}
	
	public void setLabelColor(int index, Color color) {
		labels[index].setForeground(color);
	}
}
