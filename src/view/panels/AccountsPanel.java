package view.panels;


import java.awt.CardLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import controller.CreditCardController;
import controller.UserController;
import controller.PersonalAccountController;

public class AccountsPanel extends MainMenuTabPanel {
	private static final long serialVersionUID = 3231733128092158223L;
	
	private UserController controller;
	private CardLayout cardLayout;
	
	private static final String ALL_ACCOUNTS = "all_accounts";
	private static final String ACCOUNT_HISTORY = "account_history";
	private static final String CARD_INFO = "card_info";
	
	private JPanel allAcountsPanel;
	private JPanel accountHistoryPanel;
	private JPanel creditCardInfoPanel;
	
	public AccountsPanel(UserController controller) {
		
		this.controller = controller;
		
		this.cardLayout = new CardLayout();
		this.setLayout(cardLayout);
		
		this.allAcountsPanel = new JPanel();
		this.accountHistoryPanel = new JPanel();
		this.creditCardInfoPanel = new JPanel();
		
		allAcountsPanel.removeAll();
		allAcountsPanel.add(new AllAccountsResumePanel(this, controller));
		
		this.add(allAcountsPanel, ALL_ACCOUNTS);
		this.add(accountHistoryPanel, ACCOUNT_HISTORY);
		this.add(creditCardInfoPanel, CARD_INFO);
	}
	
	
	public void switchToAllAccountsPanel() {
		allAcountsPanel.removeAll();
		allAcountsPanel.add(new AllAccountsResumePanel(this, controller));
		cardLayout.show(this, ALL_ACCOUNTS);
	}
	
	public void switchToAccountInfoPanel(PersonalAccountController controller) {
		accountHistoryPanel.removeAll();
		accountHistoryPanel.add(new PersonalAccountPanel(this, controller));
		cardLayout.show(this, ACCOUNT_HISTORY);
	}
	
	public void switchToCreditCardInfoPanel(CreditCardController controller) {
		creditCardInfoPanel.removeAll();
		creditCardInfoPanel.add(new CreditCardInfoPanel(this, controller));
		cardLayout.show(this, CARD_INFO);
	}
	
}
