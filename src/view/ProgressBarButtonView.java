package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class ProgressBarButtonView extends ContentView {
	
	private int[] possibleUpdates = new int[2];

	private static final long serialVersionUID = 8304068256917862597L;
	
	private JProgressBar progressBar = new JProgressBar();
	private GridBagConstraints c = new GridBagConstraints();
	
	public ProgressBarButtonView() {
		
		this.setLayout(new GridBagLayout());
		
		for (int i = 0; i < 4; i++) {
			addLabel(new JLabel());
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
		this.add(getLabel(0), c);
		
		c.gridx = 1;
		c.insets = new Insets(0, 0, 0, 0);
		this.add(getLabel(1), c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(0, 10, 0, 10);
		this.add(getLabel(2), c);
		
		c.gridx = 1;
		c.insets = new Insets(0, 0, 0, 0);
		this.add(getLabel(3), c);
		
		c.gridx = 2;
		c.anchor = GridBagConstraints.LINE_END;
		c.insets = new Insets(0, 0, 0, 10);
		JButton button = new JButton();
		addButton(button);
		this.add(button, c);
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
}
