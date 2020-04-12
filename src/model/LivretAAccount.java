package model;

import java.util.Date;


public class LivretAAccount extends WithdrawableAccount {

	public LivretAAccount(String iban, String name, User owner, Date date, double amount,double balanceCeiling, 
			double withdrawalceiling, double minimalBalance) {
		super(iban, name, owner, date, amount, balanceCeiling, withdrawalceiling, minimalBalance);
		this.balanceCeiling = balanceCeiling;
	}
	
	public LivretAAccount(LivretAAccount other) {
		super(other);
		this.balanceCeiling = other.balanceCeiling;
	}
	
	public double getBalanceCeiling() {
		return balanceCeiling;
	}

	@Override
	public String getType() {
		return PersonalAccount.LIVRET_A;
	}
}
