package controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;

import model.User;
import model.WithdrawableAccount;
import view.DataChangeView;
import view.ProgressBarButtonView;

public class AccountWithrdrawCeilingController extends Controller {

	private WithdrawableAccount account;
	private ProgressBarButtonView view;
	private User user;
	
	public AccountWithrdrawCeilingController(User user, WithdrawableAccount account, ProgressBarButtonView view) {
		this.user = user;
		this.account = account;
		this.view = view;
	}

	@Override
	public void displayView() {
		view.setVisible(true);
	}
	

	@Override
	public void setupViewButtons() {
		view.addButtonListener(new ButtonActionListener());
	}

	@Override
	public void setupViewText() {
		
		int min = 0;
		int max = (int) account.getWithrdrawalCeiling();
		double current = account.getCurrentlyEngagedAmount();
		int displayedCurrent = (int) current;
		
		view.setProgressBarMin(min);
		view.setProgressBarMax(max);
		view.setProgressBarCurrent(displayedCurrent);
		
		Font font = new Font(Font.SERIF, Font.ITALIC, 12);
		
		view.setLabelText(0, "Plafond: " +  Integer.toString(max));
		view.setLabelFont(0, font);
		view.setLabelText(1, "Montant engagé: " + current);
		view.setLabelFont(1, new Font(Font.SERIF, Font.ITALIC, 12));
		
		view.setAuxVisibility(false);
		
		view.setButtonText("Modifier");
		view.setBorder(BorderFactory.createTitledBorder("Plafond de payement/retrait"));
	}
	
	class ButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			DataChangeView newView = new DataChangeView(null, "Edition plafond payement/retrait", 
					true, "capacité de payement", true);
			WithdrawalCeilingChangeController controller = 
					new WithdrawalCeilingChangeController(user, newView, AccountWithrdrawCeilingController.this, account);
			controller.setupView();
			controller.displayView();
		}
	}

}
