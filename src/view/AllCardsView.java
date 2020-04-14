package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;

public class AllCardsView extends ContentView {

	private static final long serialVersionUID = -3538063302676177588L;
	private ScrollableListView scrollListView = new ScrollableListView();
	
	
	public AllCardsView() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		addButton(new JButton());
		
		scrollListView.setScrollPaneSize(new Dimension(420, 320));
		
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0,0,10,0);
		c.fill = GridBagConstraints.BOTH;
		this.add(scrollListView, c);
		
		c.gridy = 1;
		c.ipady = 10;
		c.insets = new Insets(10, 0, 0, 0);
		this.add(getButton(0), c);
	}
	
	public ScrollableListView getScrollList() {
		return scrollListView;
	}
	
}
