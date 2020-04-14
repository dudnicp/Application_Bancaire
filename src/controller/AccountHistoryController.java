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
import view.AllCardsView;
import view.ContentResumeListView;
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
		
		for (Transaction transaction: account.getPendingTransactions()) {
			TransactionView transactionView = new TransactionView();
			TransactionController controller = new TransactionController(transaction, transactionView, mainMenuController);
			controller.setupView();
			view.addContentToList(0,transactionView);
		}
		
		TitledBorder title1 = new TitledBorder("Transactions en attente");
		title1.setTitleFont(new Font("Arial", Font.BOLD, 15));
		view.setListBorder(0, title1);
		
		
		for (Transaction transaction: account.getHistory()) {
			TransactionView transactionView = new TransactionView();
			TransactionController controller = new TransactionController(transaction, transactionView, mainMenuController);
			controller.setupView();
			view.addContentToList(1,transactionView);
		}
		
		TitledBorder title2 = new TitledBorder("Transactions enregistrées");
		title2.setTitleFont(new Font("Arial", Font.BOLD, 15));
		view.setListBorder(1, title2);
	}

	
	class CardsButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			AllCardsView allCards = new AllCardsView();
			AllCardsController controller = new AllCardsController((CurrentAccount)account, allCards, mainMenuController);
			mainMenuController.changeView(allCards);
			controller.setupView();
		}
	}
	
	class InfoButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			AccountInfoView accountInfoView = new AccountInfoView();
			AccountInfoController controller = new AccountInfoController(account, accountInfoView, mainMenuController);
			mainMenuController.changeView(accountInfoView);
			controller.setupView();
		}
	}
	
	class ReturnButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ContentResumeListView accountsList = new ContentResumeListView(3,0);
			AllAccountsController controller = new AllAccountsController(
					mainMenuController.getLoggedUser(), accountsList, mainMenuController);
			mainMenuController.changeView(accountsList);
			controller.setupView();
		}
	}

	@Override
	public void setupViewButtonsActions() {
		 view.addButtonAction(0, new CardsButtonListener());
		 view.addButtonAction(1, new InfoButtonListener());
		 view.addButtonAction(2, new ReturnButtonListener());
	}
}
