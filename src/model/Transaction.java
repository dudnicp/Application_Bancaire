package model;

import java.util.Date;


public class Transaction {
	
	public static final int PENDING = 0;
	public static final int REGISTERED = 1;
	
	private Account linkedAccount;
	private double amount;
	private Date date;
	private int status;
	private String category;
	private TransactionType type;
	
	public Transaction(Account recieverAccount, 
			double amount, int status, Date date, TransactionType type) {
		this.linkedAccount = recieverAccount;
		this.amount = amount;
		this.status = status;
		this.date = new Date(date.getTime());
		this.category = InBuiltTransactionCategory.UNKNOWN.toString();
		this.type = type;
	}
	
	public Transaction(Transaction other) {
		this(other.linkedAccount, other.amount, other.status, other.date, other.type);
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public Account getLinkedAccount() {
		return linkedAccount;
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
	
	public TransactionType getType() {
		return type;
	}
	
	public int getStatus() {
		return status;
	}
}

