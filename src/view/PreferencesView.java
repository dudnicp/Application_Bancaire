package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;

public class PreferencesView extends ContentView {

	private static final long serialVersionUID = 4201335039425890796L;
	
	public PreferencesView() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		for (int i = 0; i < 6; i++) {
			addLabel(new JLabel());
		}
		
		for (int i = 0; i < 4; i++) {
			addButton(new JButton());
		}
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(40, 0, 0, 40);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.LINE_START;
		this.add(getLabel(0), c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.gridheight = 1;
		c.insets = new Insets(10, 0, 20, 40);
		this.add(getLabel(1), c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(10, 0, 00, 40);
		this.add(getLabel(2), c);
		
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.gridheight = 1;
		c.insets = new Insets(10, 0, 20, 40);
		this.add(getLabel(3), c);
		
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(10, 0, 00, 40);
		this.add(getLabel(4), c);
		
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.gridheight = 1;
		c.insets = new Insets(10, 0, 20, 40);
		this.add(getLabel(5), c);
		
		
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.gridheight = 1;
		c.insets = new Insets(40, 0, 0, 40);
		this.add(getButton(0), c);
		
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.gridheight = 1;
		c.insets = new Insets(10, 0, 0, 40);
		this.add(getButton(1), c);
		
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.gridheight = 1;
		this.add(getButton(2), c);
		
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.gridheight = 1;
		this.add(getButton(4), c);
	}
}
