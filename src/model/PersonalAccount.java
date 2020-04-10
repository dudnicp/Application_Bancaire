package model;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PersonalAccount extends Account {
	
	private double balance;
	private AccountType type;
	private PriorityQueue<Transaction> history;
	private ArrayList<Transaction> pendingTransactions;
	
	public PersonalAccount(String iban, String name, AccountType type, double amount) {
		super(iban, name);
		this.balance = amount;
		this.type = type;
		
		this.history = new PriorityQueue<Transaction>(new TransactionComparator());
		this.pendingTransactions = new ArrayList<Transaction>();
	}
	
	public PersonalAccount(PersonalAccount other) {
		this(other.getIban(), other.getName(), other.type, other.balance);
		for (Transaction transaction : other.history) {
			this.history.add(transaction);
		}
		for (Transaction transaction : other.pendingTransactions) {
			this.pendingTransactions.add(transaction);
		}
	}
	
	public void addPendingTransaction(Transaction t) {
		pendingTransactions.add(t);
	}
	
	public void addTransactionToHistory(Transaction t){
		history.add(t);
	}
	

	
	public double getBalance() {
		return balance;
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
