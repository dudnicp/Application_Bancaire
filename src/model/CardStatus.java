package model;

public enum CardStatus {
	ACTIVE("Active"),
	BLOCKED("Bloquée");
	
	private String str = "Active";
	
	CardStatus(String str) {
		this.str = str;
	}
	
	@Override
	public String toString() {
		return str;
	}
}
