package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.border.Border;

public class AllCardsView extends ContentView {

	private static final long serialVersionUID = -3538063302676177588L;
	private ScrollableListView scrollListView = new ScrollableListView();
	private JButton button = new JButton();
	
	public AllCardsView() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		scrollListView.setScrollPaneSize(new Dimension(420, 320));
		
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0,0,10,0);
		c.fill = GridBagConstraints.BOTH;
		this.add(scrollListView, c);
		
		c.gridy = 1;
		this.add(button, c);
	}
	
	public void setButtonText(String text) {
		button.setText(text);
	}
	
	public void addButtonAction(ActionListener l) {
		button.addActionListener(l);
	}
	
	public void addContentToContentBox(ContentView content) {
		scrollListView.addContentToContentBox(content);
	}
	
	public void setScrollPaneBorder(Border border) {
		scrollListView.setScrollPaneBorder(border);
	}
	
}
