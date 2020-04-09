package controller;


import model.LoginData;
import model.InvalidPasswordException;
import model.InvalidUserException;
import model.User;

public class LoginController {
	private LoginData loginData;
	
	
	public LoginController(LoginData loginData) {
		this.loginData = loginData;
	}

	
	public void login(String id, String password) {
		loginData.login(id, password);
	}
}
