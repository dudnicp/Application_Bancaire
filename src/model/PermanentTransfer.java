package model;

import java.util.Date;

public class PermanentTransfer {
	
	public static final String MONTHLY = "Mensuel";
	public static final String THREE_MONTHLY = "Trimestriel";
	public static final String BI_ANUAL = "SEMESTRIEL";
	public static final String ANNUAL = "ANNUEL";
	
	private CurrentAccount payer;
	private Account payee;
	private double amount;
	private Date firstTransactionDate;
	private String regularity;
	
	public PermanentTransfer(CurrentAccount payer, Account payee, double amount, Date firstTransactionDate, String regularity) {
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
	
	public String getRegularity() {
		return regularity;
	}
}
