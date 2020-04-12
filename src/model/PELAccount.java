package model;

import java.util.Date;


public class PELAccount extends PersonalAccount {
	
	public PELAccount(String iban, String name, User owner, Date date, double amount, int maxBalance) {
		super(iban, name, owner, date, amount, maxBalance);
	}


	public PELAccount(PELAccount other) {
		super(other);
	}
	
	@Override
	public String getType() {
		return PersonalAccount.PEL;
	}

}
