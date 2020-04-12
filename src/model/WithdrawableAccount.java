package model;

import java.util.Date;

import aux.CeilingExceedingException;
import aux.InsuficentAmountException;

public abstract class WithdrawableAccount extends PersonalAccount {
	
	protected double withrdrawalCeiling;
	protected double minBalance;

	public WithdrawableAccount(String iban, String name, User owner, Date date, 
						double amount, double balanceCeiling, double withdrawalCeiling, double minimalBalance) {
		super(iban, name, owner, date, amount, balanceCeiling);
		this.withrdrawalCeiling = withdrawalCeiling;
		this.setMinBalance(minimalBalance);
	}
	
	public WithdrawableAccount(WithdrawableAccount other) {
		super(other);
		this.withrdrawalCeiling = other.withrdrawalCeiling;
		this.minBalance = other.minBalance;
	}
	
	@SuppressWarnings("deprecation")
	public double getCurrentlyEngagedAmount() {
		double currentlyEngaged = 0;
		for (Transaction transaction : getHistory()) {
			Date today = new Date();
			if (transaction.getDate().getMonth() == today.getMonth()) {
				if (transaction.getAmount() < 0) {
					currentlyEngaged -= transaction.getAmount();
				}
			} else {
				break;
			}
		}
		
		return currentlyEngaged;
	}
	
	public Transaction pay(double amount, Account account, TransactionType type) 
					throws InsuficentAmountException, CeilingExceedingException {
		if (getBalance() > amount) {
			if (getCurrentlyEngagedAmount() + amount > withrdrawalCeiling) {
				Transaction transaction = new Transaction(account, amount, new Date(), type);
				addPendingTransaction(transaction);
				return transaction;
			} else {
				throw new CeilingExceedingException();
			}
		} else {
			throw new InsuficentAmountException();
		}
	}
	
	public double getWithrdrawalCeiling() {
		return withrdrawalCeiling;
	}
	
	public void setWithrdrawalCeiling(double withrdrawalCeiling) {
		this.withrdrawalCeiling = withrdrawalCeiling;
	}
	
	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}
	
	public double getMinBalance() {
		return minBalance;
	}
}
