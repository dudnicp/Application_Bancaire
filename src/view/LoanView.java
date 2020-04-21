package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class LoanView extends ContentView {
	private static final long serialVersionUID = -8227885088833432423L;
	
	private JProgressBar[] progressBars = new JProgressBar[2];
	
	public LoanView() {
		
		this.setBorder(BorderFactory.createRaisedBevelBorder());
		this.setPreferredSize(new Dimension(385, 150));
		this.setMaximumSize(new Dimension(385, 150));
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		for (int i = 0; i < progressBars.length; i++) {
			progressBars[i] = new JProgressBar();
		}
		
		for (int i = 0; i < 6; i++) {
			addLabel(new JLabel());
		}
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.LINE_START;
		this.add(progressBars[0], c);
		
		c.gridy = 1;
		this.add(getLabel(0), c);
		
		c.gridy = 2;
		this.add(progressBars[1], c);
		
		c.gridy = 3;
		this.add(getLabel(1), c);
		
		c.gridy = 4;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.NONE;
		this.add(getLabel(2), c);
		
		c.gridy = 5;
		this.add(getLabel(3), c);
		
		
		c.fill  = GridBagConstraints.NONE;
		c.gridx = 2;
		c.gridy = 4;
		c.anchor = GridBagConstraints.LINE_END;
		this.add(getLabel(4), c);
		
		c.gridy = 5;
		this.add(getLabel(5), c);
	}
	
	public void setProgressBarMax(int index, int max) {
		progressBars[index].setMaximum(max);
	}
	
	public void setProgressBarValue(int index, int value) {
		progressBars[index].setValue(value);
	}
}
