package model;

public enum InBuiltTransactionCategory {
	HOBBIES("Loisirs"),
	FOOD("Alimentation"),
	HEALTH("Santée"),
	TRANSPORTS("Transports"),
	UNKNOWN("Inconnue");
	
	private String str;
	
	InBuiltTransactionCategory(String str) {
		this.str = str;
	}
	
	@Override
	public String toString() {
		return str;
	}
}
