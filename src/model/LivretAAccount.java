package model;

import java.util.Date;


public class LivretAAccount extends WithdrawableAccount {

	public LivretAAccount(String iban, String name, User owner, Date date, double amount, int maxBalance,
			int minBalance, int maxWithrdraw) {
		super(iban, name, owner, date, amount, maxBalance, minBalance, maxWithrdraw);
		this.maxBalance = maxBalance;
	}
	
	public LivretAAccount(LivretAAccount other) {
		super(other);
		this.maxBalance = other.maxBalance;
	}

	@Override
	public String getType() {
		return PersonalAccount.LIVRET_A;
	}
}
