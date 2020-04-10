package model;

public abstract class TransactionType {
	
	public abstract String info();
	
	public String getDirection(double amount) {
		if (amount > 0) {
			return "De:";
		} else {
			return "Vers:";
		}
	}
}
