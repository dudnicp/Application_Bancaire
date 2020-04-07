package view;

import controller.Controller;
import model.BankData;

public class BankUserApp {
	public static void main(String[] args) {
		BankData bank = new BankData();
		Controller controller = new Controller(bank);
		LoginFrame login = new LoginFrame(controller);
	}
}
