package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class ProgressBarButtonView extends ContentView {

	private static final long serialVersionUID = 8304068256917862597L;
	
	private JProgressBar progressBar = new JProgressBar();
	private JLabel[] labels = new JLabel[2];
	private JLabel auxLabel = new JLabel();
	private JButton button = new JButton();
	private JButton auxButton = new JButton();
	
	public ProgressBarButtonView() {
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel();
		}
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.gridheight = 1;
		c.ipadx = 90;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(progressBar, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		this.add(auxLabel, c);
		
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		this.add(auxButton, c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		this.add(labels[0], c);
		
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;;
		c.gridheight = 1;
		this.add(button, c);
		
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = GridBagConstraints.REMAINDER;;
		c.gridheight = 1;
		this.add(labels[1], c);
	}
	
	public void setProgressBarMin(int min) {
		progressBar.setMaximum(min);
	}
	
	public void setProgressBarMax(int max) {
		progressBar.setMaximum(max);
	}
	
	public void setProgressBarCurrent(int current) {
		progressBar.setValue(current);
	}
	
	public void setLabelText(int index, String text) {
		labels[index].setText(text);
	}
	
	public void setLabelFont(int index, Font font) {
		labels[index].setFont(font);
	}
	
	public void setButtonText(String text) {
		button.setText(text);
	}
	
	public void addButtonListener(ActionListener l) {
		button.addActionListener(l);
	}
	
	public void setAuxVisibility(boolean b) {
		auxButton.setVisible(b);
		auxLabel.setVisible(b);
	}
	
	public void setAuxLabelText(String text) {
		auxLabel.setText(text);
	}
	
	public void setAuxLabelFont(Font font) {
		auxLabel.setFont(font);
	}
	
	public void setAuxButtonText(String text) {
		auxButton.setText(text);
	}
	
	public void addAuxButtonListener(ActionListener l) {
		auxButton.addActionListener(l);
	}
}
