package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class ContentView extends JPanel {
	private static final long serialVersionUID = -6701622778052230400L;

	
	private ArrayList<JLabel> labels = new ArrayList<JLabel>();
	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	
	public ArrayList<JLabel> allLabels() {
		return labels;
	}
	
	public ArrayList<JButton> allButtons() {
		return buttons;
	}
	
	public JLabel getLabel(int i) {
		return labels.get(i);
	}
	
	public JButton getButton(int i) {
		return buttons.get(i);
	}
	
	public void addLabel(JLabel label) {
		labels.add(label);
	}
	
	public void addButton(JButton button) {
		buttons.add(button);
	}
	
	public void setLabelText(int index, String text) {
		labels.get(index).setText(text);
	}
	
	public void setLabelColor(int index, Color color) {
		labels.get(index).setForeground(color);
	}
	
	public void setLabelFont(int index, Font font) {
		labels.get(index).setFont(font);;
	}
	
	public void setButtonText(int index, String text) {
		buttons.get(index).setText(text);
	}
	
	public void addButtonAction(int index, ActionListener action) {
		buttons.get(index).addActionListener(action);
	}
	
	public void setButtonVisibility(int index, boolean b) {
		buttons.get(index).setVisible(b);
	}
	
	public void setLabelVisibility(int index, boolean b) {
		buttons.get(index).setVisible(b);
	}

}
