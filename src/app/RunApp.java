package app;

import controller.LoginController;
import model.BankData;
import view.LoginView;

public class RunApp {

	public static void main(String[] args) {
		BankData bank = new BankData();
		LoginView loginView = new LoginView();
		LoginController loginController = new LoginController(bank, loginView);
		loginController.setupView();
		loginController.displayView();
	}

}
