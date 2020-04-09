package model;

public class AppData {
	private User loggedUser;
	private BankData bank;	
	
	public AppData(BankData bank) {
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
