package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class AccountInfoView extends ContentView{
	
	private static final long serialVersionUID = 8908845943152455195L;
	
	private int numberOfComponents = 0;
	private GridBagConstraints c = new GridBagConstraints();
	
	private Box infoBox = Box.createVerticalBox();
	
	public AccountInfoView() {
		this.setLayout(new GridBagLayout());
		
		for (int i = 0; i < 5; i++) {
			JLabel label = new JLabel();
			addLabel(label);
			infoBox.add(label);
		}
		
		c.gridx = 0;
		c.gridy = numberOfComponents;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 0, 5, 0);
		c.ipadx = 0;

		this.add(infoBox,c);
		
	}
	
	public void addContent(JComponent content) {
		c.gridx = 0;
		c.gridy = ++numberOfComponents;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.BOTH;
		this.add(content, c);
	}
	
	public void setInfoPanelBorder(Border border) {
		infoBox.setBorder(border);
	}
	
	public int getNumberOfComponents() {
		return numberOfComponents;
	}
}
