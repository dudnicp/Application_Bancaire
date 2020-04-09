package model;

public class Card {
	
	private String code;
	private String num;
	CardStatus status;
	
	public Card(String code, String num, CardStatus status) {
		this.code = code;
		this.num = num;
		this.status = status;
	}
	
	public Card(Card other) {
		this(other.code, other.num, other.status);
	}
	
	public String getCode() {
		return this.code;
	}
	
	public String getNum() {
		return this.num;
	}
	
	public CardStatus getStatus() {
		return this.status;
	}
	
	public void lockCard() {
		this.status = CardStatus.BLOQUEE;
	}
	
	public void unlockCard() {
		this.status = CardStatus.ACTIVE;
	}
}
