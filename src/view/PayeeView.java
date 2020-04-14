package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;

public class PayeeView extends ContentView {
	
	private static final long serialVersionUID = -5181276747264923888L;
	
	public PayeeView() {
		
		this.setPreferredSize(new Dimension(385, 120));
		this.setMaximumSize(new Dimension(385, 120));
		this.setBorder(BorderFactory.createRaisedBevelBorder());
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		for (int i = 0; i < 4; i++) {
			addLabel(new JLabel());
		}
		
		for (int i = 0; i < 2; i++) {
			addButton(new JButton());
		}
		
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(5, 0, 0, 0);
		this.add(getLabel(0), c);
		
		c.gridy = 1;
		c.gridwidth = 3;
		c.insets = new Insets(0, 0, 0, 0);
		this.add(getLabel(1), c);
		
		c.gridy = 2;
		c.gridheight = 1;
		c.insets = new Insets(15, 0, 0, 0);
		this.add(getLabel(2), c);
		
		
		c.gridy = 3;
		c.gridwidth = 3;
		c.insets = new Insets(5, 0, 10, 0);
		this.add(getLabel(3), c);
		
		c.gridx = 2;
		c.anchor = GridBagConstraints.CENTER;
		
		c.gridy = 0;
		c.gridheight = 1;
		c.gridheight = 1;
		c.insets = new Insets(0, 30, 0, 0);
		this.add(getButton(0), c);
		
		c.gridy = 2;
		this.add(getButton(1), c);
		
	}
}
	
