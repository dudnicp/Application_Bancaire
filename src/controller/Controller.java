package controller;


import model.AppData;
import model.InvalidPasswordException;
import model.InvalidUserException;
import model.User;

public class Controller {
	private AppData appData;
	
	
	public Controller(AppData appData) {
		this.appData = appData;
	}

	
	public void login(String id, String password) 
			throws InvalidUserException, InvalidPasswordException{
		appData.login(id, password);
	}
	
	public void deconnectCurrentUser() {
		appData.setLoggedUser(null);
	}
	
	public String createWelcomeMessage() {
		String retString = new String();
		retString += "Connected as " + appData.getLoggedUser().toString() + "\n";
		retString += "Welcome to your customer area!";
		return retString;
	}
	
	public User getLoggedUser() {
		return appData.getLoggedUser();
	}
}
