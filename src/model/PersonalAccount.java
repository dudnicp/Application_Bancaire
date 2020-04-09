package model;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PersonalAccount extends Account {
	private double amount;
	private AccountType type;
	private PriorityQueue<Transaction> history;
	private ArrayList<Transaction> pendingTransactions;
	
	public PersonalAccount(String iban, AccountType type) {
		super(iban);
		this.type = type;
		history = new PriorityQueue<Transaction>();
		pendingTransactions = new ArrayList<Transaction>();
	}
	
	
	public void addPendingTransaction(Transaction t) {
		pendingTransactions.add(t);
	}
	
	
	public double getAmount() {
		return amount;
	}
	
	public AccountType getType() {
		return type;
	}
	
	public PriorityQueue<Transaction> getHistory() {
		return history;
	}
	
	public ArrayList<Transaction> getPendingTransactions() {
		return pendingTransactions;
	}
	
	public double getPendingAmount() {
		double amount = 0;
		for (Transaction transaction : pendingTransactions) {
			amount += transaction.getAmount();
		}
		return amount;
	}
	
}
