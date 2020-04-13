package model;

import java.util.Date;

public class PermanentTransfer {
	
	private CurrentAccount payer;
	private Account payee;
	private double amount;
	private Date firstTransactionDate;
	private TransferRegularity regularity;
	
	public PermanentTransfer(CurrentAccount payer, Account payee, double amount, Date firstTransactionDate, TransferRegularity regularity) {
		this.payer = payer;
		this.payee = payee;
		this.amount = amount;
		this.firstTransactionDate = firstTransactionDate;
		this.regularity = regularity;
	}
	
	public PermanentTransfer(PermanentTransfer other) {
		this(other.payer, other.payee, other.amount, other.firstTransactionDate, other.regularity);
	}
	
	public CurrentAccount getPayer() {
		return payer;
	}
	
	public Account getPayee() {
		return payee;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public Date getFirstTransactionDate() {
		return firstTransactionDate;
	}
	
	public TransferRegularity getRegularity() {
		return regularity;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public void setRegularity(TransferRegularity regularity) {
		this.regularity = regularity;
	}
}
