package model;

public class Card {
	
	private User owner;
	private String code;
	private String number;
	CardStatus status;
	
	public Card(User owner, String code, String number) {
		this.owner = owner;
		this.code = code;
		this.number = number;
		this.status = CardStatus.ACTIVE;
	}
	
	public Card(Card other) {
		this.owner = other.owner;
		this.code = other.code;
		this.number = other.number;
		this.status = other.status;
	}
	
	public User getOwner() {
		return owner;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public String getNumber() {
		return this.number;
	}
	
	public String getShortNumber() {
		if (number.length() > 4) {
			return "X" + number.substring(number.length()-4, number.length());
		}
		else {
			return number;
		}
	}
	
	public CardStatus getStatus() {
		return this.status;
	}
	
	public void lockCard() {
		this.status = CardStatus.BLOCKED;
	}
	
	public void unlockCard() {
		this.status = CardStatus.ACTIVE;
	}
}
