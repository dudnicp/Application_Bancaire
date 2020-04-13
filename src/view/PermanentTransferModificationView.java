package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PermanentTransferModificationView extends ContentView {

	private static final long serialVersionUID = 7164127278470972060L;
	
	private JButton[] buttons = new JButton[4];
	private JPanel panel = new JPanel(new GridBagLayout());
	
	public PermanentTransferModificationView() {
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.ipadx = 30;
		c.ipady = 20;
		c.fill = GridBagConstraints.BOTH;
		
		for (int i = 0; i < buttons.length - 1; i++, c.gridy++) {
			buttons[i] = new JButton();
			panel.add(buttons[i], c);
		}
		
		buttons[3] = new JButton();
		panel.add(buttons[3], c);
		
		this.add(panel);
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
