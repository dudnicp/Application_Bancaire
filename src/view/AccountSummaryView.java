package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;

public class AccountSummaryView extends HoverableAndClickableView {

	private static final long serialVersionUID = 2556846151035574506L;
	
	public AccountSummaryView() {
		
		this.setPreferredSize(new Dimension(385, 70));
		this.setMaximumSize(new Dimension(385, 70));
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		for (int i = 0; i < 5; i++) {
			addLabel(new JLabel());
		}
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(10, 0, 0, 80);
		this.add(getLabel(0), c);
		
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = GridBagConstraints.REMAINDER;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0, 0, 0, 80);
		this.add(getLabel(1), c);
		
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.anchor = GridBagConstraints.LINE_END;
		c.insets = new Insets(0, 0, 0, 0);
		this.add(getLabel(2), c);
		
		c.gridx = 1;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(0, 0, 0, 0);
		this.add(getLabel(3), c);
		
		c.gridx = 1;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 1;
		this.add(getLabel(4), c);
	}
}
