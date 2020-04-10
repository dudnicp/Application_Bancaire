package controller;


import model.LoginData;

public class LoginController {
	private LoginData loginData;
	
	
	public LoginController(LoginData loginData) {
		this.loginData = loginData;
	}

	
	public void login(String id, String password) {
		loginData.login(id, password);
	}
	
	public void disconnectCurrentUser() {
		loginData.disconnectCurrentUser();
	}
	
	public LoginData getLoginData() {
		return loginData;
	}
}
