package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.PriorityQueue;

public abstract class PersonalAccount extends Account {
	
	public static final String CURRENT_ACCOUNT = "Compte courrant";
	public static final String PEL = "PEL";
	public static final String LIVRET_A = "Livret A";
	
	protected User owner;
	protected double balance;
	protected Date openingDate;
	protected int maxBalance;
	protected PriorityQueue<Transaction> history;
	protected ArrayList<Transaction> pendingTransactions;
	
	public PersonalAccount(String iban, String name, User owner, Date date, double amount, int maxBalance) {
		super(iban, name);
		this.owner = owner;
		this.openingDate = date;
		this.balance = amount;
		this.maxBalance = maxBalance;
		
		this.history = new PriorityQueue<Transaction>(new TransactionComparator());
		this.pendingTransactions = new ArrayList<Transaction>();
	}
	
	public PersonalAccount(PersonalAccount other) {
		this(other.getIban(), other.getName(), other.owner, other.openingDate, other.balance, other.maxBalance);
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
	
	public User getOwner() {
		return owner;
	}
	
	public double getBalance() {
		return balance;
	}

	public Date getOpeningDate() {
		return openingDate;
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
	
	public int getMinBalance() {
		return 0;
	}
	
	public int getMaxBalance() {
		return maxBalance;
	}
	
	public void setMaxBalance(int maxBalance) {
		this.maxBalance = maxBalance;
	}
	
	public abstract String getType();
}
