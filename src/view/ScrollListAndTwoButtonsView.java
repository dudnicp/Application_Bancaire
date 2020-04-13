package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.border.Border;

public abstract class ScrollListAndTwoButtonsView extends ContentView {

	private static final long serialVersionUID = 1283655078570484842L;
	
	private JButton[] buttons = new JButton[2];
	private ScrollableListView scrollList = new ScrollableListView();
	
	public ScrollListAndTwoButtonsView() {
		
		scrollList.setScrollPaneSize(new Dimension(420, 425));
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
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
		for (int i = 0; i < buttons.length; i++, c.gridy++) {
			this.add(buttons[i], c);
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
	
	public void setButtonText(int index, String text) {
		buttons[index].setText(text);
	}
	
	public void addButtonAction(int index, ActionListener actionListener) {
		buttons[index].addActionListener(actionListener);
	}
	
}
