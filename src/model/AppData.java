package model;

public class AppData {
	private User loggedUser;
	private BankData bank;	
	
	public AppData(BankData bank) {
		this.bank = bank;
	}
	
	public void setLoggedUser(User loggedUser) {
		this.loggedUser = loggedUser;
	}
	
	public User getLoggedUser() {
		return loggedUser;
	}
	
	public void login(String id, String password) 
			throws InvalidUserException, InvalidPasswordException {
		for (User client : bank.getClients()) {
			if (client.getId().equals(id)) {
				if (client.getPassword().equals(password)) {
					setLoggedUser(client);
					return;
				}
				throw new InvalidPasswordException();
			}
		}
		throw new InvalidUserException();
	}
}
