package model;


import java.util.ArrayList;

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
