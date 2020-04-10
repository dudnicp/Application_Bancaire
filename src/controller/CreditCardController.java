package controller;

import model.Card;

public class CreditCardController {
	private Card card;
	
	public CreditCardController(Card card) {
		this.card = card;
	}
	
	public Card getCard() {
		return card;
	}
}
