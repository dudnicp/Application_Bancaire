package model;
import java.util.Date;

public class Loan {
	
	private double amountToRecieve;
	private double rate;
	
	private double currentlyPaid;
	private double currentlyRecieved;
	
	private Date firstRepaymentDate;
	private Date dueDate;
	
	
	public Loan(double amountToRecieve, double rate, double currentlyRecieved, 
			double currentlyPaid, Date firstRepaymentDate, Date dueDate) {
		this.amountToRecieve = amountToRecieve;
		this.rate = rate;
		this.currentlyPaid = currentlyPaid;
		this.currentlyRecieved = currentlyRecieved;
		this.firstRepaymentDate = new Date(firstRepaymentDate.getTime());
		this.dueDate = new Date(dueDate.getTime());
	}
	
	public double getAmountToRecieve() {
		return amountToRecieve;
	}
	
	public double getCurrentlyPaid() {
		return currentlyPaid;
	}
	
	public double getCurrentlyRecieved() {
		return currentlyRecieved;
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
