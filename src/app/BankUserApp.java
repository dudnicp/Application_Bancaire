package app;


import controller.Controller;
import model.AppData;
import model.BankData;
import view.frames.LoginFrame;

public class BankUserApp {
	public static void main(String[] args) {
		BankData bank = new BankData();
		AppData appData = new AppData(bank);
		Controller controller = new Controller(appData);
		LoginFrame login = new LoginFrame(controller);
	}
}
