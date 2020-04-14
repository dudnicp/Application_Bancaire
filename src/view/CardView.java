package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;


public class CardView extends ContentView {
	
	private static final long serialVersionUID = 8856070653088403069L;
	
	
	public CardView() {
		
		this.setPreferredSize(new Dimension(385, 70));
		this.setMaximumSize(new Dimension(385, 70));
		
		this.setLayout(new GridBagLayout());
		this.setBorder(BorderFactory.createRaisedBevelBorder());
		GridBagConstraints c = new GridBagConstraints();
		
		for (int i = 0; i < 3; i++) {
			addLabel(new JLabel());
		}
		
		addButton(new JButton());
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(10, 10, 5, 20);
		c.anchor = GridBagConstraints.LINE_START;
		this.add(getLabel(0), c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(0, 10, 10, 0);
		this.add(getLabel(1), c);
		
		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(10, 0, 0, 10);
		c.anchor = GridBagConstraints.LINE_END;
		this.add(getLabel(2), c);
		
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(0, 0, 10, 10);
		this.add(getButton(0), c);
	}
}
