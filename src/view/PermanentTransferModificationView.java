package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PermanentTransferModificationView extends ContentView {

	private static final long serialVersionUID = 7164127278470972060L;
	
	private JPanel panel = new JPanel(new GridBagLayout());
	
	public PermanentTransferModificationView() {
		
		JPanel globalPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.ipadx = 100;
		c.ipady = 15;
		c.fill = GridBagConstraints.BOTH;
		
		for (int i = 0; i < 3; i++, c.gridy++) {
			JButton button = new JButton();
			addButton(button);
			panel.add(button, c);
		}
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.anchor = GridBagConstraints.PAGE_END;
		c.fill = GridBagConstraints.HORIZONTAL;
		globalPanel.add(panel);
		
		
		
		c.gridy = 1;
		c.ipadx = 0;
		c.ipady = 10;
		c.insets = new Insets(100, 0, 0, 0);
		JButton button = new JButton();
		addButton(button);
		globalPanel.add(button, c);
		
		this.setLayout(new BorderLayout());
		this.add(globalPanel, BorderLayout.SOUTH);
	}
	
	public void setContentBorder(Border border) {
		panel.setBorder(border);
	}
	
}
