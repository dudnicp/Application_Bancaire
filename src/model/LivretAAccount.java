package model;

import java.util.Date;


public class LivretAAccount extends WithdrawableAccount {
	
	private int maxBalance;

	public LivretAAccount(String iban, String name, User owner, Date date, double amount,
			int minBalance, int maxWithrdraw, int maxBalance) {
		super(iban, name, owner, date, amount, minBalance, maxWithrdraw);
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
