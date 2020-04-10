package model;

import java.util.ArrayList;

import model.events.Event;
import model.events.LoginEvent;
import model.paterns.Observable;
import model.paterns.Observer;

public class LoginData implements Observable {
	private ArrayList<Observer> observers;
	
	private User loggedUser;
	private BankData bank;	
	
	public LoginData(BankData bank) {
		
		this.observers = new ArrayList<Observer>();
		
		this.bank = bank;
		this.loggedUser = null;
	}
	
	public void setLoggedUser(User loggedUser) {
		this.loggedUser = loggedUser;
	}
	
	public User getLoggedUser() {
		return loggedUser;
	}
	
	public void login(String id, String password) {
		for (User client : bank.getClients()) {
			if (client.getId().equals(id)) {
				if (client.getPassword().equals(password)) {
					setLoggedUser(client);
					notifyObservers(new LoginEvent(LoginEvent.SUCCESSFUL, client));
				} else {
					notifyObservers(new LoginEvent(LoginEvent.INVALID_PASSWORD));
				}
				return;
			}
		}
		notifyObservers(new LoginEvent(LoginEvent.INVALID_ID));
		return;
	}
	
	public void disconnectCurrentUser() {
		this.loggedUser = null;
		notifyObservers(new LoginEvent(LoginEvent.DISCONNECTED));
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
