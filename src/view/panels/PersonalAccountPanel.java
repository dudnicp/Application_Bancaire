package view.panels;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.LoginController;
import model.PersonalAccount;
import model.Transaction;

public class PersonalAccountPanel extends JPanel {

	private static final long serialVersionUID = -2614588421297138167L;

	private PersonalAccount linkedAccount;
	private AccountsPanel parrentTab;
	private LoginController controller;
	
	public PersonalAccountPanel(PersonalAccount linkedAccount, AccountsPanel parentTab, LoginController controller) {
		this.linkedAccount = linkedAccount;
		this.parrentTab = parentTab;
		this.controller = controller;
		
		
		Box history = Box.createVerticalBox();
		for (Transaction transaction: linkedAccount.getHistory()) {
//		
		}
		
		JScrollPane scrollPane = new JScrollPane(history);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setPreferredSize(new Dimension(400, 400));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		this.add(scrollPane);
		
		
		
		
		
		
		
		
		JButton backButton = new JButton("Retour");
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parentTab.switchToAllAccountsPanel();
			}
		});
		
		this.add(backButton);
	}

}
