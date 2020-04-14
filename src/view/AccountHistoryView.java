package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.border.Border;

public class AccountHistoryView extends ContentView {

	private static final long serialVersionUID = -1457620948356582102L;
	private ScrollableList[] scrollLists = new ScrollableList[2];
	
	public AccountHistoryView() {
		
		for (int i = 0; i < scrollLists.length; i++) {
			scrollLists[i] = new ScrollableList();
			scrollLists[i].setScrollPaneSize(new Dimension(420, 200));
		}
		
		for (int i = 0; i < 3; i++) {
			addButton(new JButton());
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
		
		for (JButton button : allButtons()) {
			this.add(button, c);
			c.gridy ++;
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
	
	public void setButtonVisibility(int index, boolean b) {
		getButton(index).setVisible(b);
	}
}
