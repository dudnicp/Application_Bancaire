package controller;

import model.BankData;
import model.InvalidPasswordException;
import model.InvalidUserException;

public class Controller {
	private BankData bank;
	
	void validateAppCheckIn(String id, String password) {
		try {
			bank.validateUser(id, password);
			// TODO enter app view
			
		} catch (InvalidPasswordException e) {
			// TODO notify view invalid password (message box)
		} catch (InvalidUserException e) {
			// TODO: notify view invalid user (message box)
		}
	}
}
