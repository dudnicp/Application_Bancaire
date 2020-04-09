package view.panels;

import javax.swing.JPanel;

import controller.LoginController;
import model.Card;

public class CreditCardInfoPanel extends JPanel {
	
	private static final long serialVersionUID = 5640132158978517923L;
	
	private Card linkedCard;
	private AccountsPanel parentTab;
	private LoginController controller;
	
	public CreditCardInfoPanel(Card card, AccountsPanel parentTab, LoginController controller) {
		this.linkedCard = card;
		this.parentTab = parentTab;
		this.controller = controller;
	}
}
