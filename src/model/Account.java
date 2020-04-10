package model;

public class Account {
	private String name;
	private String iban;
	
	public Account(String iban, String name) {
		this.iban = iban;
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public String getIban() {
		return iban;
	}
	
	public String getName() {
		return name;
	}
}
