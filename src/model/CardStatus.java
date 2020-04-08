package model;

public enum CardStatus {
	ACTIVE("Active"),
	BLOQUEE("Bloquée");
	
	private String str = "Active";
	
	CardStatus(String str) {
		this.str = str;
	}
	
	@Override
	public String toString() {
		return str;
	}
}
