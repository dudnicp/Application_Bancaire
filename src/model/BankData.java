package model;

import java.util.ArrayList;

public class BankData {
	private ArrayList<BankClient> clients;
	
	
	public BankData() {
		clients.add(new BankClient("123456789", "helloworld"));
	}
	
	public ArrayList<BankClient> getClients() {
		return clients;
	}
	
	public void validateUser(String id, String password) 
			throws InvalidUserException, InvalidPasswordException {
		for (BankClient client : clients) {
			if (client.getId().equals(id)) {
				if (client.getPassword().equals(password)) {
					return;
				}
				throw new InvalidPasswordException();
			}
		}
		throw new InvalidUserException();
	}
}
