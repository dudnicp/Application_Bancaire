package view.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import controller.LoginController;
import model.PersonalAccount;

public class AccountSmallResumePanel extends JPanel implements MouseListener {
	private static final long serialVersionUID = -3601361845540054272L;

	private AccountsPanel parentTab;
	private PersonalAccount linkedAccount;
	private LoginController controller;
	
	public AccountSmallResumePanel(PersonalAccount account, AccountsPanel parenTab, 
														LoginController controller) {
		
		this.linkedAccount = account;
		this.parentTab = parenTab;
		this.controller = controller;
		
		this.setPreferredSize(new Dimension(400, 100));
		this.setMaximumSize(new Dimension(400, 100));
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		
		JLabel nameLabel = new JLabel(linkedAccount.getName());
		nameLabel.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = GridBagConstraints.REMAINDER;
		c.insets = new Insets(0, 0, 0, 80);
		this.add(nameLabel, c);
		
		
		Double amount = linkedAccount.getAmount();
		JLabel amountLabel = new JLabel(amount.toString() + " €");
		amountLabel.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(10, 0, 10, 0);
		this.add(amountLabel, c);
		
		JLabel pendingLabel = new JLabel("En traitement:");
		pendingLabel.setFont(new Font(Font.SERIF, Font.ITALIC, 10));
		c.gridx = 1;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(0, 0, 0, 0);
		this.add(pendingLabel, c);
		
		Double pendingAmount = linkedAccount.getPendingAmount();
		JLabel pendingAmountLabel = new JLabel();
		pendingAmountLabel.setFont(new Font(Font.SERIF, Font.ITALIC, 15));
		if (pendingAmount <= 0) {
			pendingAmountLabel.setText(pendingAmount.toString() + " €");
			pendingAmountLabel.setForeground(new Color(200, 50, 50));
		} else if (pendingAmount > 0) {
			pendingAmountLabel.setText("+" + pendingAmount.toString() + " €");
			pendingAmountLabel.setForeground(new Color(50,200,50 ));
		}
		c.gridx = 1;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 1;
		this.add(pendingAmountLabel, c);
		
		
		this.setBorder(BorderFactory.createRaisedBevelBorder());
		
		this.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		parentTab.setupAccountHistoryPanel(linkedAccount);
		parentTab.switchToAccountInfoPanel();
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
		if(this.contains(e.getPoint())) {
			parentTab.setupAccountHistoryPanel(linkedAccount);
			parentTab.switchToAccountInfoPanel();	
		}
	}
}
