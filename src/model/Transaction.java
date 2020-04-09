package model;

import java.util.Date;

public class Transaction {
	private Account recieverAccount;
	private double amount;
	private Date date;
	private String category;
	
	public Transaction(Account recieverAccount, double amount, Date date) {
		this.recieverAccount = recieverAccount;
		this.amount = amount;
		this.date = new Date(date.getTime());
		this.category = InBuiltTransactionCategory.UNKNOWN.toString();
	}
	
	public Transaction(Transaction other) {
		this(other.recieverAccount, other.amount, other.date);
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
	public Account getRecieverAccount() {
		return recieverAccount;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public Date getDate() {
		return date;
	}
	
	public String getCategory() {
		return category;
	}
	
}

