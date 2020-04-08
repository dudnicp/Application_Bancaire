package model;


import java.util.ArrayList;

public class BankData {
	private ArrayList<User> clients;
	
	
	public BankData() {
		clients = new ArrayList<User>();
		clients.add(new User("12345", "hello", "Paul", "Dudnic", "Lord"));
	}
	
	public ArrayList<User> getClients() {
		return clients;
	}
	
	public User getUserFromId(String id) throws InvalidUserException{
		for (User user : clients) {
			if (user.getId().equals(id)) {
				return user;
			}
		}
		throw new InvalidUserException();
	}
}
