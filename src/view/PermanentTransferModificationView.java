package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PermanentTransferModificationView extends ContentView {

	private static final long serialVersionUID = 7164127278470972060L;
	
	private JButton[] buttons = new JButton[4];
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
		
		for (int i = 0; i < buttons.length - 1; i++, c.gridy++) {
			buttons[i] = new JButton();
			panel.add(buttons[i], c);
		}
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.anchor = GridBagConstraints.PAGE_END;
		c.fill = GridBagConstraints.HORIZONTAL;
		globalPanel.add(panel);
		
		c.gridy = 1;
		buttons[3] = new JButton();
		c.ipadx = 0;
		c.ipady = 10;
		c.insets = new Insets(100, 0, 0, 0);
		globalPanel.add(buttons[3], c);
		
		this.setLayout(new BorderLayout());
		this.add(globalPanel, BorderLayout.SOUTH);
	}
	
	public void setButtonText(int index, String text) {
		buttons[index].setText(text);
	}
	
	public void addButtonAction(int index, ActionListener actionListener) {
		buttons[index].addActionListener(actionListener);
	}
	
	public void setContentBorder(Border border) {
		panel.setBorder(border);
	}
	
}
