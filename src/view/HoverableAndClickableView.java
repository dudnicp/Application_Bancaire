package view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.UIManager;

public abstract class HoverableAndClickableView extends ContentView implements MouseListener {

	private static final long serialVersionUID = 1282515315559820524L;
	
	private ArrayList<Interaction> interactions = new ArrayList<Interaction>();
	
	public HoverableAndClickableView() {
		this.setBorder(BorderFactory.createRaisedBevelBorder());
		this.addMouseListener(this);
	}
	
	public void addInteraction(Interaction i) {
		interactions.add(i);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		for (Interaction interaction : interactions) {
			interaction.perform();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.setBackground(UIManager.getColor("TabbedPane.background"));
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.setBackground(UIManager.getColor("Panel.background"));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.setBorder(BorderFactory.createLoweredBevelBorder());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.setBorder(BorderFactory.createRaisedBevelBorder());
	}
}
