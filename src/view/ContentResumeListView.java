package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.border.Border;

public class ContentResumeListView extends ContentView {
	private static final long serialVersionUID = -3910085196143230755L;

	private ArrayList<ScrollableList> contentLists = new ArrayList<ScrollableList>();
	
	public ContentResumeListView(int nLists, int nButtons) {
		
		for (int i = 0; i < nLists; i++) {
			contentLists.add(new ScrollableList());
		}
		
		for (int i = 0; i < nButtons; i++) {
			addButton(new JButton());
		}
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.gridheight = 1;
		
		for (ScrollableList scrollableList : contentLists) {
			this.add(scrollableList, c);
			scrollableList.setScrollPaneSize(new Dimension(MainMenuView.MAIN_PANEL_WIDTH - 30, 
						(MainMenuView.MAIN_PANEL_HEIGHT - ((nButtons == 0)? 40 : (35*nButtons))) / nLists));
			c.gridy ++;
		}
		
		for (JButton button : allButtons()) {
			this.add(button, c);
			c.gridy ++;
		}
	}
	
	public void setContentListSize(int index, Dimension dimension) {
		contentLists.get(index).setScrollPaneSize(dimension);
	}
	
	public void setContentListBorder(int index, Border border) {
		contentLists.get(index).setScrollPaneBorder(border);
	}
	
	public void addContentToList(int index, ContentView content) {
		contentLists.get(index).addContentToContentBox(content);
	}
}
