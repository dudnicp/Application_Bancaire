package controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;

import model.CurrentAccount;
import model.PersonalAccount;
import model.Transaction;
import view.AccountHistoryView;
import view.AccountInfoView;
import view.AllAccountsView;
import view.TransactionView;

public class AccountHistoryController extends Controller {
	
	private PersonalAccount account;
	private AccountHistoryView view;
	private MainMenuController mainMenuController;
	
	public AccountHistoryController(PersonalAccount account, AccountHistoryView view, MainMenuController controller) {
		this.account = account;
		this.view = view;
		this.mainMenuController = controller;
	}
	
	@Override
	public void setupViewText() {
		if (account instanceof CurrentAccount) {
			view.setButtonVisibility(0, true);
		}
		else {
			view.setButtonVisibility(0, false);
		}
		view.setButtonText(0, "Cartes associées");
		view.setButtonText(1, "Informations compte");
		view.setButtonText(2, "Retour à la liste des comptes");
		
		
		for (Transaction transaction: account.getHistory()) {
			TransactionView transactionView = new TransactionView();
			TransactionController controller = new TransactionController(transaction, transactionView, mainMenuController);
			controller.setupView();
			controller.displayView();
			view.addContentToContentBox(transactionView);
		}
		
		TitledBorder titleBorder = new TitledBorder("Historique des transactions");
		titleBorder.setTitleFont(new Font("Arial", Font.BOLD, 15));
		view.setScrollPaneBorder(titleBorder);
	}

	@Override
	public void displayView() {
		view.setVisible(true);
	}
	
	class CardsButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			AccountInfoView accountInfoView = new AccountInfoView();
			AccountInfoController controller = new AccountInfoController(account, accountInfoView, mainMenuController);
			mainMenuController.changeView(accountInfoView);
			controller.setupView();
			controller.displayView();
		}
	}
	
	class InfoButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			AccountInfoView accountInfoView = new AccountInfoView();
			AccountInfoController controller = new AccountInfoController(account, accountInfoView, mainMenuController);
			mainMenuController.changeView(accountInfoView);
			controller.setupView();
			controller.displayView();
		}
	}
	
	class ReturnButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			AllAccountsView accountsList = new AllAccountsView();
			AllAccountsController controller = new AllAccountsController(
					mainMenuController.getLoggedUser(), accountsList, mainMenuController);
			mainMenuController.changeView(accountsList);
			controller.setupView();
			controller.displayView();
		}
	}

	@Override
	public void setupViewButtons() {
		 view.addButtonAction(0, new CardsButtonListener());
		 view.addButtonAction(1, new InfoButtonListener());
		 view.addButtonAction(2, new ReturnButtonListener());
	}
}
