package model;

public enum AccountType {
	COMPTE_COURRANT("Compte Courrant"),
	PEL("PEL"),
	LIVRET_A("Livret A");
	
	private String str = "";
	
	AccountType(String str) {
		this.str = str;
	}
	
	@Override
	public String toString() {
		return str;
	}
}
