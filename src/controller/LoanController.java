package controller;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import model.Loan;
import view.LoanView;

public class LoanController  extends Controller {
	Loan loan;
	LoanView view;
	
	public LoanController(Loan loan, LoanView view) {
		this.loan = loan;
		this.view = view;
	}

	@Override
	public void setupViewButtonsActions() {
		// no buttons here
		
	}

	@Override
	public void setupViewText() {
		view.setPrgoressBarMax(0, (int) loan.getAmountToRecieve());
		view.setProgressBarValue(0,(int) loan.getCurrentlyRecievedAmount());
		view.setLabelText(0, "Montant recu:   " + loan.getCurrentlyRecievedAmount() + " / " + loan.getAmountToRecieve());
		
		view.setPrgoressBarMax(1, (int) loan.getAmountToPay());
		view.setProgressBarValue(1, (int) loan.getCurrentlyPaidAmount());
		view.setLabelText(1, "Montant payé:   " + loan.getCurrentlyPaidAmount() + " / " + loan.getAmountToPay());
		
		
		DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		String date1 = dateFormat.format(loan.getFirstRepaymentDate());
		String date2 = dateFormat.format(loan.getDueDate());
		
		view.setLabelText(2, "Date du premier remboursement:");
		view.setLabelText(3, date1);
		
		view.setLabelText(4, "Échéance:");
		view.setLabelText(5, date2);
	}
}
