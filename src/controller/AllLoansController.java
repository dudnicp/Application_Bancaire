package controller;

import java.awt.Font;

import javax.swing.border.TitledBorder;

import model.Loan;
import model.User;
import view.AllLoansView;
import view.LoanView;

public class AllLoansController extends Controller {
	
	private AllLoansView view;
	private User user;

	@Override
	public void displayView() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setupViewButtonsActions() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void setupViewText() {
		TitledBorder titleBorder = new TitledBorder("Cartes Associées");
		titleBorder.setTitleFont(new Font("Arial", Font.BOLD, 15));
		view.setScrollPaneBorder(titleBorder);
		
		for (Loan loan: user.getLoans()) {
			LoanView loanView = new LoanView();
			view.addContentToContentBox(loanView);
		}
			
	}

}
