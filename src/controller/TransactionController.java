package controller;


import java.util.Date;

import model.Account;
import model.Transaction;

public class TransactionController {
	private Transaction transaction;
	
	public TransactionController(Transaction transaction) {
		this.transaction = transaction;
	}
	
	public Transaction getTransaction() {
		return transaction;
	}
	
	public String getRecieverAccountName() {
		return transaction.getRecieverAccount().getName();
	}
	
	public double getTransactionAmount() {
		return transaction.getAmount();
	}
	
	public Date getTransactionDate() {
		return transaction.getDate();
	}
	
	public String getTransactionCategory() {
		return transaction.getCategory();
	}
	
	public String getTransactionTypeInfo() {
		return transaction.getType().info();
	}
	
	public String getTransactionDirection() {
		return transaction.getType().getDirection(transaction.getAmount());
	}
	
	public void setTransactionCategory(String category) {
		transaction.setCategory(category);
	}
	
	
	
}
