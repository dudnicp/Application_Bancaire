package model;

public class DebitTransaction extends TransactionType {

	@Override
	public String info() {
		return "PRELEVEMENT";
	}

	@Override
	public String getDirection(double amount) {
		return "De:";
	}

}
