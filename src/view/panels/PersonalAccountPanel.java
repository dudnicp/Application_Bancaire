package view.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;


import controller.PersonalAccountController;
import controller.TransactionController;
import model.Transaction;

public class PersonalAccountPanel extends JPanel {

	private static final long serialVersionUID = -2614588421297138167L;

	private AccountsPanel parrentTab;
	private PersonalAccountController controller;
	
	public PersonalAccountPanel(AccountsPanel parentTab, PersonalAccountController controller) {
		this.parrentTab = parentTab;
		this.controller = controller;
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		Box history = Box.createVerticalBox();
		
		for (Transaction transaction : controller.getPersonnalAccount().getHistory()) {
			history.add(new TransactionResumePanel(new TransactionController(transaction)));
		}
		
		
		JScrollPane scrollPane = new JScrollPane(history);
		TitledBorder titledBorder = new TitledBorder("Historique des transactions");
		titledBorder.setTitleFont(new Font("Arial", Font.BOLD, 15));
		scrollPane.setBorder(titledBorder);
		scrollPane.setPreferredSize(new Dimension(420, 310));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton associatedCardsButton = new JButton("Cartes associées");
		associatedCardsButton.addActionListener(new AssociatedCardsButtonListener());
		JButton accountCeilingButton = new JButton("Consulter plafond");
		accountCeilingButton.addActionListener(new AccountCeilingButtonListener());
		JButton returnButton = new JButton("Retour à la liste des comptes");
		returnButton.addActionListener(new ReturnButtonListener());
		
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(0, 0, 10, 0);
		this.add(scrollPane, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.ipadx = 50;
		c.insets = new Insets(0, 0, 0, 0);
		this.add(associatedCardsButton, c);
		
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		this.add(accountCeilingButton, c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.gridheight = 1;
		this.add(returnButton, c);
	}
	
	
	class ReturnButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			parrentTab.switchToAllAccountsPanel();
		}
	}
	
	class AssociatedCardsButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		}
	}
	
	class AccountCeilingButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		}
	}
}
