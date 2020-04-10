package model;

import java.util.ArrayList;
import java.util.Date;

import model.events.Event;
import model.events.TransactionCategoryEvent;
import model.paterns.Observable;
import model.paterns.Observer;

public class Transaction implements Observable {
	
	private ArrayList<Observer> observers;
	
	private Account recieverAccount;
	private double amount;
	private Date date;
	private String category;
	private TransactionType type;
	
	public Transaction(Account recieverAccount, 
			double amount, Date date, TransactionType type) {
		this.recieverAccount = recieverAccount;
		this.amount = amount;
		this.date = new Date(date.getTime());
		this.category = InBuiltTransactionCategory.UNKNOWN.toString();
		this.type = type;
	}
	
	public Transaction(Transaction other) {
		this(other.recieverAccount, other.amount, other.date, other.type);
	}
	
	public void setCategory(String category) {
		this.category = category;
		notifyObservers(new TransactionCategoryEvent(category, 
				TransactionCategoryEvent.KNOWN_CATEGORY));		
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
	
	public TransactionType getType() {
		return type;
	}

	@Override
	public void addObserver(Observer obs) {
		observers.add(obs);
	}

	@Override
	public void removeObservers() {
		observers = new ArrayList<Observer>();
	}

	@Override
	public void notifyObservers(Event e) {
		for (Observer observer : observers) {
			observer.update(e);
		}
	}
}

