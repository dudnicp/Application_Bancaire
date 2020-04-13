package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class ProgressBarButtonView extends ContentView {
	
	private int[] possibleUpdates = new int[2];

	private static final long serialVersionUID = 8304068256917862597L;
	
	private JProgressBar progressBar = new JProgressBar();
	private JLabel[] labels = new JLabel[4];
	private JLabel[] auxLabels = new JLabel[2];
	private JButton button = new JButton();
	private JButton auxButton = new JButton();
	private GridBagConstraints c = new GridBagConstraints();
	
	public ProgressBarButtonView() {
		
		this.setLayout(new GridBagLayout());
		
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel();
		}
		
		for (int i = 0; i < auxLabels.length; i++) {
			auxLabels[i] = new JLabel();
		}
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.gridheight = 1;
		c.ipadx = 200;
		c.insets = new Insets(0, 10, 0, 10);
		c.anchor = GridBagConstraints.LINE_START;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(progressBar, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.ipadx = 0;
		c.insets = new Insets(0, 10, 0, 0);
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_START;
		this.add(labels[0], c);
		
		c.gridx = 1;
		c.insets = new Insets(0, 0, 0, 0);
		this.add(labels[1], c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(0, 10, 0, 10);
		this.add(labels[2], c);
		
		c.gridx = 1;
		c.insets = new Insets(0, 0, 0, 0);
		this.add(labels[3], c);
		
		c.gridx = 2;
		c.anchor = GridBagConstraints.LINE_END;
		c.insets = new Insets(0, 0, 0, 10);
		this.add(button, c);
	}
	
	public void addAuxComponents() {
		c.gridx = 0;
		c.gridy = 3;
		c.insets = new Insets(0, 10, 0, 0);
		c.anchor = GridBagConstraints.LINE_START;
		this.add(auxLabels[0], c);
		
		c.gridx = 1;
		c.insets = new Insets(0, 0, 0, 00);
		this.add(auxLabels[1], c);
		
		c.gridx = 2;
		c.insets = new Insets(0, 0, 00, 10);
		c.anchor = GridBagConstraints.LINE_END;
		this.add(auxButton, c);
	}
	
	public void setPossibleModification(int index, int id) {
		possibleUpdates[index] = id;
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
	
	public void setAuxLabelText(int index, String text) {
		auxLabels[index].setText(text);
	}
	
	public void setAuxLabelFont(int index, Font font) {
		auxLabels[index].setFont(font);
	}
	
	public void setAuxButtonText(String text) {
		auxButton.setText(text);
	}
	
	public void addAuxButtonListener(ActionListener l) {
		auxButton.addActionListener(l);
	}
}
