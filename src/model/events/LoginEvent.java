package model.events;

import model.User;

public class LoginEvent extends Event {
	public static final int INVALID_ID = 0;
	public static final int INVALID_PASSWORD = 1;
	public static final int SUCCESSFUL = 2;
	
	private int loginStatus;
	private User loggedUser;
	
	public LoginEvent() {
		this.loginStatus = INVALID_ID;
		this.loggedUser = null;
	}
	
	public LoginEvent(int status) {
		this.loginStatus = status;
		this.loggedUser = null;
	}
	
	public LoginEvent(int status, User user) {
		this.loginStatus = status;
		this.loggedUser = user;
	}
	
	public void setLoggedUser(User loggedUser) {
		this.loggedUser = loggedUser;
	}
	
	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	}
	
	public int getLoginStatus() {
		return loginStatus;
	}
	
	public User getLoggedUser() {
		return loggedUser;
	}
}
