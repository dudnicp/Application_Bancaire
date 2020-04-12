package model;

import java.util.ArrayList;
import java.util.Date;

public class CurrentAccount extends WithdrawableAccount {
	
	private ArrayList<Card> cards = new ArrayList<Card>();

	public CurrentAccount(String iban, String name, User owner, Date date, double amount, double balanceCeiling,
			double withdrawalceiling, int minimalBalance) {
		super(iban, name, owner, date, amount, balanceCeiling, withdrawalceiling, minimalBalance);
	}
	
	public CurrentAccount(CurrentAccount other) {
		super(other);
	}

	@Override
	public String getType() {
		return PersonalAccount.CURRENT_ACCOUNT;
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}

}
