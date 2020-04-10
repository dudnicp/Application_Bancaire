package model;

public class Card {
	
	private String code;
	private String number;
	CardStatus status;
	
	public Card(String code, String num, CardStatus status) {
		this.code = code;
		this.number = num;
		this.status = status;
	}
	
	public Card(Card other) {
		this(other.code, other.number, other.status);
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
