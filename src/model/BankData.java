package model;


import java.util.ArrayList;

import aux.InvalidPasswordException;
import aux.InvalidUserException;
import exampleData.ExampleUsers;

public class BankData {
	private ArrayList<User> clients;
	
	public BankData() {
		clients = new ArrayList<User>();
		ExampleUsers data = new ExampleUsers();
		for (User user : data) {
			clients.add(user);
		}
	}
	
	public User login(String id, String password) 
			throws InvalidUserException, InvalidPasswordException {
		for (User client : clients) {
			if (client.getId().equals(id)) {
				if (client.getPassword().equals(password)) {
					return client;
				} else {
					throw new InvalidPasswordException();
				}
			}
		}
		throw new InvalidUserException();
	}
	
	
	public ArrayList<User> getClients() {
		return clients;
	}
	
	public User getUserFromId(String id) {
		for (User user : clients) {
			if (user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}
}
