package controller;
import model.BankData;
import model.InvalidPasswordException;
import model.InvalidUserException;

public class Controller {
	private BankData bank;
	
	public Controller(BankData bank) {
		this.bank = bank;
	}
	
	public void validateLogin(String id, String password) throws InvalidUserException, InvalidPasswordException{
		bank.validateUser(id, password);
	}
}
