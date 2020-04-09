package view.panels;


import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.LoginController;
import model.Card;
import model.PersonalAccount;

public class AccountsPanel extends JPanel {
	private static final long serialVersionUID = 3231733128092158223L;
	
	private LoginController controller;
	private CardLayout cardLayout;
	
	private static final String ALL_ACCOUNTS = "all_accounts";
	private static final String ACCOUNT_HISTORY = "account_history";
	private static final String CARD_INFO = "card_info";
	
	private JPanel allAcountsPanel;
	private JPanel accountHistoryPanel;
	private JPanel creditCardInfoPanel;
	
	public AccountsPanel(LoginController controller) {
		
		this.controller = controller;
		
		this.cardLayout = new CardLayout();
		this.setLayout(cardLayout);
		
		this.allAcountsPanel = new JPanel();
		this.accountHistoryPanel = new JPanel();
		this.creditCardInfoPanel = new JPanel();
		
		setupAllAcountsPanel();
		
		this.add(allAcountsPanel, ALL_ACCOUNTS);
		this.add(accountHistoryPanel, ACCOUNT_HISTORY);
		this.add(creditCardInfoPanel, CARD_INFO);
	}
	
	
	public void setupAllAcountsPanel() {
		Box allAcounts = Box.createVerticalBox();
		for (PersonalAccount account: controller.getLoggedUser().getAccounts()) {
			allAcounts.add(new AccountSmallResumePanel(account, this, controller));
		}
		
		JScrollPane scrollPane = new JScrollPane(allAcounts);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setPreferredSize(new Dimension(400, 400));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		allAcountsPanel.add(scrollPane);
	}
	
	public void setupAccountHistoryPanel(PersonalAccount account) {
		accountHistoryPanel.removeAll();
		accountHistoryPanel.add(new PersonalAccountPanel(account, this, controller));
	}
	
	public void setupCreditCardInfoPanel(Card card) {
		creditCardInfoPanel.removeAll();
		creditCardInfoPanel.add(new CreditCardInfoPanel(card, this, controller));
	}
	
	public void switchToAllAccountsPanel() {
		cardLayout.show(this, ALL_ACCOUNTS);
	}
	
	public void switchToAccountInfoPanel() {
		cardLayout.show(this, ACCOUNT_HISTORY);
	}
	
	public void switchToCreditCardInfoPanel() {
		cardLayout.show(this, CARD_INFO);
	}
	
}
