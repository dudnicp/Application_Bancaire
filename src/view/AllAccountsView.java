package view;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.border.Border;

public class AllAccountsView extends ContentView {
	private static final long serialVersionUID = -1628958296597509487L;
	
	ScrollableListView[] scrollLists = new ScrollableListView[3];
	
	public AllAccountsView() {
		
		Box content = Box.createVerticalBox();
		for (int i = 0; i < scrollLists.length; i++) {
			scrollLists[i] = new ScrollableListView();
			scrollLists[i].setScrollPaneSize(new Dimension(420, 155));
			content.add(scrollLists[i]);
		}
		this.add(content);
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
	
}
