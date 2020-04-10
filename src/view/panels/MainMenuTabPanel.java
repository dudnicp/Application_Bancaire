package view.panels;

import javax.swing.JPanel;

public abstract class MainMenuTabPanel extends JPanel{
	
	private static final long serialVersionUID = 6946016614031117456L;

	public void reset() {
		this.removeAll();
	}
}
