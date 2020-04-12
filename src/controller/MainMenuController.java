package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import model.BankData;
import model.User;
import view.AllAccountsView;
import view.ContentView;
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
	public void displayView() {
		view.setVisible(true);
	}


	@Override
	public void setupViewText() {
		view.setMainButtonText(0, "Comptes");
		view.setMainButtonText(1, "Virements");
		view.setMainButtonText(2, "Emprunts");
		
		view.setSecundaryButtonText(0, "Réglages");
		view.setSecundaryButtonText(1, "Déconnexion");
		view.setSecundaryButtonText(2, "Quitter");
		
		AllAccountsView accountsList = new AllAccountsView();
		AllAccountsController controller = new AllAccountsController(loggedUser, accountsList, this);
		controller.setupView();
		controller.displayView();
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
			AllAccountsView accountsList = new AllAccountsView();
			AllAccountsController controller = new AllAccountsController(loggedUser, accountsList, MainMenuController.this);
			changeView(accountsList);
			controller.setupView();
			controller.displayView();
		}
	}
	
	public MainMenuView getView() {
		return view;
	}
	
	class TransfersButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	class LoansButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	class PreferencesButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			PreferencesView preferencesView = new PreferencesView();
			PreferencesController controller = new PreferencesController(loggedUser, preferencesView);
			changeView(preferencesView);
			controller.setupView();
			controller.displayView();
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
			newLoginController.displayView();
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
	public void setupViewButtons() {
		view.addMainButtonAction(0, new AccountButtonListener());
		view.addMainButtonAction(1, new TransfersButtonListener());
		view.addMainButtonAction(2, new LoansButtonListener());
		
		view.addSecundaryButtonAction(0, new PreferencesButtonListener());
		view.addSecundaryButtonAction(1, new LogoutButtonListener());
		view.addSecundaryButtonAction(2, new QuitButtonListener());
	}
}
