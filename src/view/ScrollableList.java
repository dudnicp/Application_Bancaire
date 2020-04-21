package view;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.border.Border;


public class ScrollableList extends ContentView {
	
	private static final long serialVersionUID = -4576083498662424254L;
	private Box contentBox;
	private JScrollPane scrollPane;
	
	public ScrollableList() {
		contentBox = Box.createVerticalBox();
		scrollPane = new JScrollPane(contentBox);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		this.add(scrollPane);
	}
	
	public void addContentToContentBox(ContentView content) {
		contentBox.add(content);
	}
	
	public void setScrollPaneBorder(Border border) {
		scrollPane.setBorder(border);
	}
	
	public void setScrollPaneSize(Dimension dim) {
		scrollPane.setPreferredSize(dim);
	}
}
