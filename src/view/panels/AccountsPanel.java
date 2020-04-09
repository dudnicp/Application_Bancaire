package view.panels;


import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.Controller;
import model.AccountSmallResumePanel;
import model.PersonalAccount;

public class AccountsPanel extends JPanel {
	private static final long serialVersionUID = 3231733128092158223L;
	
	private Controller controller;
	
	public AccountsPanel(Controller controller) {
		this.controller = controller;
		
		Box allAcounts = Box.createVerticalBox();
		
		
		for (PersonalAccount account: controller.getLoggedUser().getAccounts()) {
			allAcounts.add(new AccountSmallResumePanel(account));
		}
		
		JScrollPane scrollPane = new JScrollPane(allAcounts);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setPreferredSize(new Dimension(400, 400));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		
		this.add(scrollPane);
	}
}
