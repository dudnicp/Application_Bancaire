package model;

import java.util.ArrayList;
import java.util.Date;

public class CurrentAccount extends WithdrawableAccount {
	
	private ArrayList<Card> cards = new ArrayList<Card>();

	public CurrentAccount(String iban, String name, User owner, Date date, double amount,
			int minBalance, int maxWithrdraw) {
		super(iban, name, owner, date, amount, minBalance, maxWithrdraw);
	}
	
	public CurrentAccount(CurrentAccount other) {
		super(other);
	}

	@Override
	public String getType() {
		return PersonalAccount.CURRENT_ACCOUNT;
	}
	
	public ArrayList<Card> getCards() {
		return cards;
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}

}
