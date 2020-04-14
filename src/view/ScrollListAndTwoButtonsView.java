package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.border.Border;

public abstract class ScrollListAndTwoButtonsView extends ContentView {

	private static final long serialVersionUID = 1283655078570484842L;

	protected ScrollableListView scrollList = new ScrollableListView();
	
	public ScrollListAndTwoButtonsView() {
		
		scrollList.setScrollPaneSize(new Dimension(420, 425));
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		for (int i = 0; i < 2; i++) {
			addButton(new JButton());
		}
		
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.gridheight = 1;
		this.add(scrollList, c);
		
		c.gridy = 1;
		c.ipady = 5;
		c.insets = new Insets(0, 0, 0, 0);
		for (JButton button : allButtons()) {
			this.add(button, c);
			c.gridy ++;
		}
	}
	
	public void addContentToList(ContentView content) {
		scrollList.addContentToContentBox(content);
	}
	
	public void setListBorder(Border border) {
		scrollList.setScrollPaneBorder(border);
	}
	
	public void setListSize(Dimension dim) {
		scrollList.setScrollPaneSize(dim);
	}
}
