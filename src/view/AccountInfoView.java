package view;

import java.awt.Font;
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
	private JLabel[] infoLabels = new JLabel[5];
	
	public AccountInfoView() {
		this.setLayout(new GridBagLayout());
		
		for (int i = 0; i < infoLabels.length; i++) {
			infoLabels[i] = new JLabel();
			infoBox.add(infoLabels[i]);
		}
		
		c.gridx = 0;
		c.gridy = numberOfComponents;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 0, 5, 0);
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
	
	public void setInfoLabelText(int index, String text) {
		infoLabels[index].setText(text);
	}
	
	public void setInfoLabelFont(int index, Font font) {
		infoLabels[index].setFont(font);
	}
	
	public int getNumberOfComponents() {
		return numberOfComponents;
	}
}
