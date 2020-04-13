package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;

public class TransactionView extends HoverableAndClickableView {

	private static final long serialVersionUID = -3736913984381958423L;
	private JLabel[] labels = new JLabel[6];
	
	public TransactionView() {
		
		this.setPreferredSize(new Dimension(385, 90));
		this.setMaximumSize(new Dimension(385, 90));
		
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel();
		}
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.anchor = GridBagConstraints.LINE_START;
		c.insets = new Insets(0, 0, 0, 0);
		this.add(labels[0], c);
		
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(00, 40, 0, 0);
		this.add(labels[1], c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.LINE_START;
		c.insets = new Insets(0, 0, 0, 0);
		this.add(labels[2], c);
		
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(0, 0, 0, 0);
		this.add(labels[3], c);
		
		c.gridx = 1;
		c.gridy = 2;
		c.insets = new Insets(0, 40, 0, 0);
		c.anchor = GridBagConstraints.LAST_LINE_END;
		this.add(labels[4], c);
		
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(0, 40, 0, 0);
		c.anchor = GridBagConstraints.LAST_LINE_END;
		this.add(labels[5], c);
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
