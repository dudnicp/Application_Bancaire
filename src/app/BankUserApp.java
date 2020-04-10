package app;


import controller.UserController;
import model.LoginData;
import model.BankData;
import view.frames.AppFrame;
import view.frames.LoginFrame;

public class BankUserApp {
	public static void main(String[] args) {
		BankData bank = new BankData();
		LoginData loginData = new LoginData(bank);
		UserController controller = new UserController(loginData);
		LoginFrame loginFrame = new LoginFrame(controller);
//		AppFrame app = new AppFrame();
		loginData.addObserver(loginFrame);
	}
}
