package model;

public class Account {
	protected String name;
	protected String iban;
	
	public Account(String iban, String name) {
		this.iban = iban;
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Account(Account other) {
		this(other.iban, other.name);
	}
	
	public String getIban() {
		return iban;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name + " - IBAN : " + iban;
	}
}
