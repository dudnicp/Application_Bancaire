package model;
import java.util.Date;

public class Loan {
	
	private PermanentTransfer forUser, forBank;
	
	public Loan(PermanentTransfer forUser, PermanentTransfer forBank) {
		this.forUser = new PermanentTransfer(forUser);
		this.forBank = new PermanentTransfer(forBank);
	}
	
	public Loan(Loan other) {
		this(other.forUser, other.forBank);
	}
	
	public double getMyMontant() {
		return this.forUser.getamount();
	}
	
	public double getAmountToSend() {
		return this.forBank.getamount();
	}
	
	public Date getDateRecieve() {
		return this.forUser.getBeginDate();
	}
	
	public Date getDateToSend() {
		return this.forBank.getBeginDate();
	}
	
	public double getMyRegul() {
		return this.forUser.getRegul();
	}
	
	public double getBankRegul() {
		return this.forBank.getRegul();
	}
	
	public double getTaux() {
		return (this.getAmountToSend()/this.getMyMontant())-1;
	}
}
