package controller;

import model.Account;

public class AccountController {
	protected Account account;
	
	public AccountController(Account account) {
		this.account = account;
	}
	
	public Account getAccount() {
		return account;
	}
	
	public String getAccountName() {
		return account.getName();
	}
	
	public String getAccountIban() {
		return account.getIban();
	}
}
