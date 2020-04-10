package controller;


import java.util.ArrayList;

import model.Account;
import model.LoginData;
import model.PersonalAccount;
import model.User;

public class UserController {
	private LoginData loginData;
	
	
	public UserController(LoginData loginData) {
		this.loginData = loginData;
	}

	
	public void login(String id, String password) {
		loginData.login(id, password);
	}
	
	public void disconnectCurrentUser() {
		loginData.disconnectCurrentUser();
	}
	
	public LoginData getLoginData() {
		return loginData;
	}
	
	public User getLoggedUser() {
		return loginData.getLoggedUser();
	}
	
	public String getUserPersonalData() {
		return loginData.getLoggedUser().personalData();
	}
	
	public String getUserPhone() {
		return loginData.getLoggedUser().getPhoneNumber();
	}
	
	public String getUserMail() {
		return loginData.getLoggedUser().getEmail();
	}
	
	public ArrayList<PersonalAccount> getUserAccounts() {
		return loginData.getLoggedUser().getAccounts();
	}
	
	public ArrayList<Account> getUserBeneficiaries() {
		return loginData.getLoggedUser().getBeneficiaries();
	}
	
	public void addTransactionCategory(String category) {
		loginData.getLoggedUser().addTransactionCategory(category);
	}
	
	public void addBeneficiary(String iban, String name) {
		loginData.getLoggedUser().addBeneficiary(new Account(iban, name));
	}
}
