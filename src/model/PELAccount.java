package model;

import java.util.Date;

import aux.PermanentsTransfersTowardPELException;


public class PELAccount extends PersonalAccount {
	
	public PELAccount(String iban, String name, User owner, Date date, double amount, int maxBalance) {
		super(iban, name, owner, date, amount, maxBalance);
	}


	public PELAccount(PELAccount other) {
		super(other);
	}
	
	@Override
	public String getType() {
		return PersonalAccount.PEL;
	}
	
	public void close(CurrentAccount dest) throws PermanentsTransfersTowardPELException{
		Transaction transaction = new Transaction(this, getBalance(), Transaction.PENDING, new Date(), new OneTimeTransferTransaction());
		dest.addTransaction(transaction);
		owner.closePel(this);
		for (PermanentTransfer permanentTransfer : owner.getPermanentTransfers()) {
			if (permanentTransfer.getPayee().equals(this)) {
				 throw new PermanentsTransfersTowardPELException();
			}
		}
	}
	
}
