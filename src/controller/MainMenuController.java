package controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;

import model.BankData;
import model.Loan;
import model.User;
import view.SummaryListView;
import view.ContentView;
import view.LoanView;
import view.LoginView;
import view.MainMenuView;
import view.PreferencesView;

public class MainMenuController extends Controller {
	private User loggedUser;
	private BankData bank;
	private MainMenuView view;
	
	public MainMenuController(User user, BankData bank, MainMenuView view) {
		this.loggedUser = user;
		this.bank = bank;
		this.view = view;
	}
	


	@Override
	public void setupViewText() {
		view.setMainButtonText(0, "Comptes");
		view.setMainButtonText(1, "Virements");
		view.setMainButtonText(2, "Emprunts");
		
		view.setSecundaryButtonText(0, "Réglages");
		view.setSecundaryButtonText(1, "Déconnexion");
		view.setSecundaryButtonText(2, "Quitter");
		
		SummaryListView accountsList = new SummaryListView(3,0);
		AllAccountsController controller = new AllAccountsController(loggedUser, accountsList, this);
		controller.setupView();
		view.changeContent(accountsList);
	}
	
	public User getLoggedUser() {
		return loggedUser;
	}
	
	public void changeView(ContentView newView) {
		view.changeContent(newView);
	}
	
	
	class AccountButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			SummaryListView accountsList = new SummaryListView(3,0);
			AllAccountsController controller = new AllAccountsController(loggedUser, accountsList, MainMenuController.this);
			changeView(accountsList);
			controller.setupView();
		}
	}
	
	public MainMenuView getView() {
		return view;
	}
	
	class TransfersButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			SummaryListView transfersView = new SummaryListView(1, 2);
			AllTransfersController controller = new AllTransfersController(loggedUser, transfersView, MainMenuController.this);
			changeView(transfersView);
			controller.setupView();
		}
	}
	
	class LoansButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			SummaryListView allLoans = new SummaryListView(1, 0);
			for (Loan loan : loggedUser.getLoans()) {
				LoanView loanView = new LoanView();
				LoanController controller = new LoanController(loan, loanView);
				allLoans.addContentToList(0, loanView);
				controller.setupView();
			}
			TitledBorder titleBorder = new TitledBorder("Liste des emprunts");
			titleBorder.setTitleFont(new Font("Arial", Font.BOLD, 15));
			allLoans.setContentListBorder(0, titleBorder);
			changeView(allLoans);
		}
	}
	
	class PreferencesButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			PreferencesView preferencesView = new PreferencesView();
			PreferencesController controller = new PreferencesController(loggedUser, preferencesView);
			changeView(preferencesView);
			controller.setupView();
		}
	}
	
	class LogoutButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			view.showLogoutMessage();
			view.dispose();
			LoginView newLoginView = new LoginView();
			LoginController newLoginController = new LoginController(bank, newLoginView);
			newLoginController.setupView();
		}
	}
	
	class QuitButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			view.showLogoutMessage();
			view.dispose();
		}
	}

	@Override
	public void setupViewButtonsActions() {
		view.addMainButtonAction(0, new AccountButtonListener());
		view.addMainButtonAction(1, new TransfersButtonListener());
		view.addMainButtonAction(2, new LoansButtonListener());
		
		view.addSecundaryButtonAction(0, new PreferencesButtonListener());
		view.addSecundaryButtonAction(1, new LogoutButtonListener());
		view.addSecundaryButtonAction(2, new QuitButtonListener());
	}
}
