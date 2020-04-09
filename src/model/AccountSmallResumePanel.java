package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AccountSmallResumePanel extends JPanel {
	private static final long serialVersionUID = -3601361845540054272L;

	private PersonalAccount linkedAccount;
	
	public AccountSmallResumePanel(PersonalAccount account) {
		this.linkedAccount = account;
		
		this.setPreferredSize(new Dimension(200, 100));
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		
		JLabel nameLabel = new JLabel(linkedAccount.getName());
		nameLabel.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = GridBagConstraints.REMAINDER;
//		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0, 0, 0, 80);
		this.add(nameLabel, c);
		
		
		Double amount = linkedAccount.getAmount();
		JLabel amountLabel = new JLabel(amount.toString() + "€");
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
		JLabel pendingAmountLabel = new JLabel(pendingAmount.toString() + "€");
		pendingAmountLabel.setFont(new Font(Font.SERIF, Font.ITALIC, 15));
		if (pendingAmount < 0) {
			pendingAmountLabel.setForeground(Color.RED);
		} else if (pendingAmount > 0) {
			pendingAmountLabel.setForeground(Color.GREEN);
		}
		c.gridx = 1;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 1;
		this.add(pendingAmountLabel, c);
		
		this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
	}
}
