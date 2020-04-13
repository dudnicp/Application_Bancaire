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
		return this.forUser.getAmount();
	}
	
	public double getAmountToSend() {
		return this.forBank.getAmount();
	}
	
	public Date getDateRecieve() {
		return this.forUser.getFirstTransactionDate();
	}
	
	public Date getDateToSend() {
		return this.forBank.getFirstTransactionDate();
	}
	
	public TransferRegularity getMyRegularity() {
		return this.forUser.getRegularity();
	}
	
	public TransferRegularity getBankRegularity() {
		return this.forBank.getRegularity();
	}
	
	public double getTaux() {
		return (this.getAmountToSend()/this.getMyMontant())-1;
	}
}
