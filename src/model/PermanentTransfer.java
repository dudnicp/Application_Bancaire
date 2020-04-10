package model;

import java.util.Date;

public class PermanentTransfer {
	private double regul;
	private Date beginDate;
	private double amount;
	private PersonalAccount receivor;
	
	
	public PermanentTransfer(double regul, Date begindate, double amount, PersonalAccount receivor){
		this.regul = regul;
		this.beginDate = begindate;
		this.amount = amount;
		this.receivor = new PersonalAccount(receivor);
	}
	
	public PermanentTransfer(PermanentTransfer other) {
		this(other.regul, other.beginDate, other.amount, other.receivor);
	}
	
	public double getRegul() {
		return this.regul;
	}
	
	public Date getBeginDate() {
		return this.beginDate;
	}
	
	public double getamount() {
		return this.amount;
	}
	
	public PersonalAccount getReceive() {
		return this.receivor;
	}
	
	public void setRegul(double regul) {
		this.regul = regul;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public void setDate(Date date) {
		this.beginDate = new Date(date.getTime());
	}
}
