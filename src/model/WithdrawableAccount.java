package model;

import java.util.Date;

import aux.CeilingExceedingException;
import aux.InsuficentAmountException;

public abstract class WithdrawableAccount extends PersonalAccount {
	
	protected int maxWithrdraw;
	protected int minBalance;

	public WithdrawableAccount(String iban, String name, User owner, Date date, 
						double amount, int maxBalance, int minBalance, int maxWithrdraw) {
		super(iban, name, owner, date, amount, maxBalance);
		this.maxWithrdraw = maxWithrdraw;
		this.minBalance = minBalance;
	}
	
	public WithdrawableAccount(WithdrawableAccount other) {
		super(other);
		this.maxWithrdraw = other.maxWithrdraw;
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
			if (getCurrentlyEngagedAmount() + amount > maxWithrdraw) {
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
	
	public int getMaxWithdraw() {
		return maxWithrdraw;
	}
	
	public void setMaxWithrdraw(int maxWithrdraw) {
		this.maxWithrdraw = maxWithrdraw;
	}
	
	public void setMinBalance(int minBalance) {
		this.minBalance = minBalance;
	}
	
	@Override
	public int getMinBalance() {
		return minBalance;
	}
}
