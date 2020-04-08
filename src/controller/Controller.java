package controller;


import model.AppData;
import model.InvalidPasswordException;
import model.InvalidUserException;

public class Controller {
	private AppData appData;
	
	
	public Controller(AppData appData) {
		this.appData = appData;
	}

	
	public void login(String id, String password) 
			throws InvalidUserException, InvalidPasswordException{
		appData.login(id, password);
	}
	
	public String createWelcomeMessage() {
		String retString = new String();
		retString += "Connected as " + appData.getLoggedUser().toString() + "\n";
		retString += "Welcome to your customer area!";
		return retString;
	}
}
