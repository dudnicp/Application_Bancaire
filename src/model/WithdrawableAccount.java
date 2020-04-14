package model;

import java.util.Date;

import aux.CustomException;
import aux.InsuficentAmountException;
import aux.MinimalBalanceUnderflowException;
import aux.WithdrawCapacityOverflowException;

public abstract class WithdrawableAccount extends PersonalAccount {
	
	protected int maxWithdraw;

	public WithdrawableAccount(String iban, String name, User owner, Date date, 
						double amount, int minBalance, int maxWithrdraw) {
		super(iban, name, owner, date, amount, minBalance);
		this.maxWithdraw = maxWithrdraw;
		this.minBalance = minBalance;
	}
	
	public WithdrawableAccount(WithdrawableAccount other) {
		super(other);
		this.maxWithdraw = other.maxWithdraw;
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
		for (Transaction transaction : getPendingTransactions()) {
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
	
	public void pay(double amount, Account payee, TransactionType type) 
					throws InsuficentAmountException, WithdrawCapacityOverflowException, MinimalBalanceUnderflowException {
		if (getBalance() < amount) {
			throw new InsuficentAmountException();
		}
		if (getCurrentlyEngagedAmount() + amount > maxWithdraw) {
			throw new WithdrawCapacityOverflowException();
		}
		if (getMinBalance() > getBalance() - amount) {
			throw new MinimalBalanceUnderflowException();
		}
		this.addTransaction(new Transaction(payee, -amount, Transaction.PENDING, new Date(), type));
		payee.addTransaction(new Transaction(this, amount, Transaction.PENDING, new Date(), type));
	}
	
	public int getMaxWithdraw() {
		return maxWithdraw;
	}
	
	public void addToMaxWithdraw(int amount) throws CustomException {
		this.maxWithdraw += amount;
	}
	
	@Override
	public int getMinBalance() {
		return minBalance;
	}
}
