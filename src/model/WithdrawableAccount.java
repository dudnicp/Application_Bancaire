package model;

import java.util.Date;

import aux.CustomException;
import aux.InsuficentAmountException;
import aux.WithdrawalCapacityExceedingException;

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
					throws InsuficentAmountException, WithdrawalCapacityExceedingException {
		if (getBalance() >= amount) {
			if (getCurrentlyEngagedAmount() + amount <= maxWithrdraw) {
				this.addTransaction(new Transaction(payee, -amount, Transaction.PENDING, new Date(), type));
				payee.addTransaction(new Transaction(this, amount, Transaction.PENDING, new Date(), type));
			} else {
				throw new WithdrawalCapacityExceedingException();
			}
		} else {
			throw new InsuficentAmountException();
		}
	}
	
	public int getMaxWithdraw() {
		return maxWithrdraw;
	}
	
	public void setMaxWithrdraw(int maxWithrdraw) throws CustomException {
		if (maxWithrdraw < getCurrentlyEngagedAmount()) {
			throw new CustomException(
					"Modification impossible : la nouvelle capacité de payement "
					+ "doit être supérieure au montant actuellement engagé.");
		}
		this.maxWithrdraw = maxWithrdraw;
	}
	
	public void setMinBalance(int minBalance) throws CustomException {
		if (minBalance > balance) {
			throw new CustomException("Modification impossible : le nouveau seuil doit être inférieur au solde actuel.");
		}
		this.minBalance = minBalance;
	}
	
	@Override
	public int getMinBalance() {
		return minBalance;
	}
}
