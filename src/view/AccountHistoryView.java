package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.border.Border;

public class AccountHistoryView extends ContentView {

	private static final long serialVersionUID = -1457620948356582102L;
	private ScrollableListView scrollableList = new ScrollableListView();
	private JButton[] buttons = new JButton[3];
	
	public AccountHistoryView() {
		
		scrollableList.setScrollPaneSize(new Dimension(420, 400));
		
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
		}
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(0, 0, 10, 0);
		this.add(scrollableList, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(0, 0, 0, 0);
		this.add(buttons[0], c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = 1;
		this.add(buttons[1], c);
		
		c.gridx = 0;
		c.gridy = 3;
		c.gridheight = 1;
		this.add(buttons[2], c);
	}
	
	public void addContentToContentBox(ContentView content) {
		scrollableList.addContentToContentBox(content);
	}
	
	public void setScrollPaneBorder(Border border) {
		scrollableList.setScrollPaneBorder(border);
	}
	
	public void setScrollPaneSize(Dimension dim) {
		scrollableList.setScrollPaneSize(dim);
	}
	
	public void setButtonText(int index, String text) {
		buttons[index].setText(text);
	}
	
	public void addButtonAction(int index, ActionListener actionListener) {
		buttons[index].addActionListener(actionListener);
	}
	
	public void setButtonVisibility(int index, boolean b) {
		buttons[index].setVisible(b);
	}
}
