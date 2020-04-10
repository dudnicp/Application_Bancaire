package controller;

import model.Account;
import model.PersonalAccount;

public class PersonalAccountController extends AccountController {

	public PersonalAccountController(Account account) {
		super(account);
	}
	
	public PersonalAccount getPersonnalAccount() {
		return (PersonalAccount) account;
	}
	
	public double getAccountBalance() {
		return ((PersonalAccount) account).getBalance();
	}
	
	public double getAccountPendingAmount() {
		return ((PersonalAccount) account).getPendingAmount();
	}
}
