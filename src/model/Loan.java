package model;
import java.util.Date;

public class Loan {
	
	private double amountToRecieve;
	private double amountToPay;
	private double rate;
	
	private double currentlyPaidAmount;
	private double currentlyRecievedAmount;
	
	private Date firstRepaymentDate;
	private Date dueDate;
	
	
	public Loan(double amountToRecieve, double amountToPay, double rate, double currentlyRecieved, 
			double currentlyPaid, Date firstRepaymentDate, Date dueDate) {
		this.amountToRecieve = amountToRecieve;
		this.amountToPay = amountToPay;
		this.rate = rate;
		this.currentlyPaidAmount = currentlyPaid;
		this.currentlyRecievedAmount = currentlyRecieved;
		this.firstRepaymentDate = new Date(firstRepaymentDate.getTime());
		this.dueDate = new Date(dueDate.getTime());
	}
	
	public double getAmountToPay() {
		return amountToPay;
	}
	
	public double getAmountToRecieve() {
		return amountToRecieve;
	}
	
	public double getCurrentlyPaidAmount() {
		return currentlyPaidAmount;
	}
	
	public double getCurrentlyRecievedAmount() {
		return currentlyRecievedAmount;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	
	public Date getFirstRepaymentDate() {
		return firstRepaymentDate;
	}
	
	public double getRate() {
		return rate;
	}
	
}
