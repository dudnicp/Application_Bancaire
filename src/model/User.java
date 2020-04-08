package model;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class User {
	private String firstName;
	private String lastName;
	private String title;
	private String email;
	private String phoneNumber;
	
	private String id;
	private String password;
	
	public User(String id, String password, String firstName, String lastName, String title) {
		this.id = id;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
	}
	
	public String getId() {
		return id;
	}
	
	public String getPassword() {
		return password;
	}
	
	@Override
	public String toString() {
		String retString = new String();
		retString += title + " " + firstName + " " + lastName;
		return retString;
	}
}
