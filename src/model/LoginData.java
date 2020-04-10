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
		this.loggedUser = new User("", "", "", "", "");
		for (int i = 0; i < 20; i++) {		
			PersonalAccount newAccount = new PersonalAccount("Compte" + i, 
					AccountType.COMPTE_COURRANT, 100);
			newAccount.setName("Compte" + i);
			loggedUser.addPersonalAccount(newAccount);
		}
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
					notifyObserver(new LoginEvent(LoginEvent.SUCCESSFUL, client));
				} else {
					notifyObserver(new LoginEvent(LoginEvent.INVALID_PASSWORD));
				}
				return;
			}
		}
		notifyObserver(new LoginEvent(LoginEvent.INVALID_ID));
		return;
	}
	
	public void disconnectCurrentUser() {
		this.loggedUser = null;
		notifyObserver(new LoginEvent(LoginEvent.DISCONNECTED));
	}

	@Override
	public void addObserver(Observer obs) {
		observers.add(obs);
	}

	@Override
	public void removeObserver() {
		observers = new ArrayList<Observer>();
	}

	@Override
	public void notifyObserver(Event e) {
		for (Observer observer : observers) {
			observer.update(e);
		}
	}
}
