package model;

public enum InBuiltTransactionCategory {
	HOBBIES("Hobbies"),
	FOOD("Food"),
	HEALTH("Health"),
	TRANSPORTS("Transports"),
	UNKNOWN("Unknown");
	
	private String str;
	
	InBuiltTransactionCategory(String str) {
		this.str = str;
	}
	
	@Override
	public String toString() {
		return str;
	}
}
