package view.panels;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import controller.UserController;
import controller.PersonalAccountController;
import model.PersonalAccount;

public class AllAccountsResumePanel extends JPanel {
	private static final long serialVersionUID = 9095767964064426801L;
	
	private UserController controller;
	private AccountsPanel parentPanel;
	
	public AllAccountsResumePanel(AccountsPanel parrent, UserController controller) {
		this.parentPanel = parrent;
		this.controller = controller;
		
		Box allAcounts = Box.createVerticalBox();
		for (PersonalAccount account: controller.getUserAccounts()) {
			allAcounts.add(new AccountSmallResumePanel(parentPanel, 
								new PersonalAccountController(account)));
		}
		
		JScrollPane scrollPane = new JScrollPane(allAcounts);
		TitledBorder titledBorder = new TitledBorder("Liste des comptes");
		titledBorder.setTitleFont(new Font("Arial", Font.BOLD, 15));
		scrollPane.setBorder(titledBorder);
		scrollPane.setPreferredSize(new Dimension(420, 350));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		this.add(scrollPane);
	}
}
