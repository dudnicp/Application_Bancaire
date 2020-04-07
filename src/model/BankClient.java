package model;


public class BankClient {
	private String id;
	private String password;
	
	public BankClient(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	public String getId() {
		return id;
	}
	
	public String getPassword() {
		return password;
	}
}
