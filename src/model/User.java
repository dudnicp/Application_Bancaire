package model;

import java.util.ArrayList;

public class User {
	
	/* User personal data */
	private String firstName;
	private String lastName;
	private String title;
	private String email;
	private String phoneNumber;
	private String adress;
	
	/* Login Data */
	private String id;
	private String password;
	
	/* Accounts */
	private ArrayList<PersonalAccount> accounts;
	private ArrayList<Account> beneficiaries;
	
	/* Misc */
	private ArrayList<String> transactionCategories;
	
	
	
	public User(String id, String password, String firstName, String lastName, 
			String title, String email, String phoneNumber, String adress) {
		
		this.id = id;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.adress = adress;
		
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
		return String.valueOf(phoneNumber).replaceFirst(
				"(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d+)", "$1 $2 $3 $4 $5");
	}
	
	public String getAdress() {
		return adress;
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
	
	public ArrayList<String> getTransactionCategories() {
		return transactionCategories;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setAdress(String adress) {
		this.adress = adress;
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
		}
	}
}
