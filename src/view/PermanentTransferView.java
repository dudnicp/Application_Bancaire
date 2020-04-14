package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class PermanentTransferView extends HoverableAndClickableView {

	private static final long serialVersionUID = 5232674417777798173L;
	
	
	public PermanentTransferView() {
		
		this.setPreferredSize(new Dimension(385, 150));
		this.setMaximumSize(new Dimension(385, 150));
		
		this.setLayout(new GridBagLayout());
		this.setBorder(BorderFactory.createRaisedBevelBorder());
		GridBagConstraints c = new GridBagConstraints();
		
		for (int i = 0; i < 8; i++) {
			addLabel(new JLabel());
		}
		
		c.ipady = 3;
		c.gridwidth = 3;
		c.gridheight = 1;
		c.insets = new Insets(5, 0, 0, 0);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(5, 0, 0, 0);
		this.add(getLabel(0), c);
		
		c.gridy = 1;
		c.insets = new Insets(0, 0, 0, 0);
		this.add(getLabel(1), c);
		
		c.gridy = 2;
		c.insets = new Insets(5, 0, 0, 0);
		this.add(getLabel(2), c);
		
		c.gridy = 3;
		c.insets = new Insets(0, 0, 0, 0);
		this.add(getLabel(3), c);
		
		c.gridy = 4;
		c.gridwidth = 1;
		c.anchor = GridBagConstraints.FIRST_LINE_END;
		c.insets = new Insets(5, 0, 0, 0);
		this.add(getLabel(4), c);
		
		c.gridx = 1;
		c.gridy = 4;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.insets = new Insets(5, 0, 0, 0);
		this.add(getLabel(5), c);
		
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 2;
		c.insets = new Insets(5, 0, 0, 0);
		this.add(getLabel(6), c);
		
		c.gridx = 2;
		c.gridy = 5;
		c.insets = new Insets(5, 0, 10, 0);
		this.add(getLabel(8), c);
	}
}
