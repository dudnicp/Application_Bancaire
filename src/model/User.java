package model;

import java.util.ArrayList;

import model.events.Event;
import model.events.TransactionCategoryEvent;
import model.paterns.Observable;
import model.paterns.Observer;

public class User implements Observable{
	
	ArrayList<Observer> observers;
	
	
	/* User personal data */
	private String firstName;
	private String lastName;
	private String title;
	private String email;
	private String phoneNumber;
	
	/* Login Data */
	private String id;
	private String password;
	
	/* Accounts */
	private ArrayList<PersonalAccount> accounts;
	private ArrayList<Account> beneficiaries;
	
	/* Misc */
	private ArrayList<String> transactionCategories;
	
	
	
	public User(String id, String password, String firstName, String lastName, String title) {
		
		observers = new ArrayList<Observer>();
		
		this.id = id;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		
		accounts = new ArrayList<PersonalAccount>();
		beneficiaries = new ArrayList<Account>();
		
		transactionCategories = new ArrayList<String>();
		for (InBuiltTransactionCategory type: InBuiltTransactionCategory.values()) {
			transactionCategories.add(type.toString());
		}
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getId() {
		return id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public ArrayList<PersonalAccount> getAccounts() {
		return accounts;
	}
	
	public ArrayList<Account> getBeneficiaries() {
		return beneficiaries;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public void addPersonalAccount(PersonalAccount account) {
		accounts.add(account);
		beneficiaries.add(account);
	}
	
	public void addBeneficiary(String iban, String name) {
		addBeneficiary(new Account(iban, name));
	}
	
	public void addBeneficiary(Account account) {
		beneficiaries.add(account);
	}
	
	
	public String personalData() {
		String retString = new String();
		retString += title + " " + firstName + " " + lastName;
		return retString;
	}

	public void addTransactionCategory(String category) {
		if (!transactionCategories.contains(category)) {
			transactionCategories.add(category);
			notifyObservers(new TransactionCategoryEvent(category, 
					TransactionCategoryEvent.UNKNOWN_CATEGORY));
		} else {
			notifyObservers(new TransactionCategoryEvent(category, 
					TransactionCategoryEvent.KNOWN_CATEGORY));
		}
	}
	
	
	@Override
	public void addObserver(Observer obs) {
		observers.add(obs);
	}

	@Override
	public void removeObservers() {
		observers = new ArrayList<Observer>();
	}
	
	@Override
	public void notifyObservers(Event e) {
		for (Observer observer : observers) {
			observer.update(e);
		}
	}
}
