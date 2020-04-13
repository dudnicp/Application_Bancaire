package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.border.Border;

public class AccountHistoryView extends ContentView {

	private static final long serialVersionUID = -1457620948356582102L;
	private ScrollableListView[] scrollLists = new ScrollableListView[2];
	private JButton[] buttons = new JButton[3];
	
	public AccountHistoryView() {
		
		for (int i = 0; i < scrollLists.length; i++) {
			scrollLists[i] = new ScrollableListView();
			scrollLists[i].setScrollPaneSize(new Dimension(420, 200));
		}
		
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
		}
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 0;
		
		for (int i = 0; i < scrollLists.length; i++, c.gridy++) {
			this.add(scrollLists[i], c);
		}
		
		for (int i = 0; i < buttons.length; i++, c.gridy++) {
			this.add(buttons[i], c);
		}
				
	}
	
	public void addContentToList(int index, ContentView content) {
		scrollLists[index].addContentToContentBox(content);
	}
	
	public void setListBorder(int index, Border border) {
		scrollLists[index].setScrollPaneBorder(border);
	}
	
	public void setListSize(int index, Dimension dim) {
		scrollLists[index].setScrollPaneSize(dim);
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
