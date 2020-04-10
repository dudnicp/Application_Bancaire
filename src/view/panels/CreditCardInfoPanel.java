package view.panels;

import javax.swing.JPanel;

import controller.CreditCardController;

public class CreditCardInfoPanel extends JPanel {
	
	private static final long serialVersionUID = 5640132158978517923L;
	
	private AccountsPanel parentTab;
	private CreditCardController controller;
	
	public CreditCardInfoPanel(AccountsPanel parentTab, CreditCardController controller) {
		this.parentTab = parentTab;
		this.controller = controller;
	}
}
