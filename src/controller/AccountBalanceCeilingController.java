package controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;

import model.PELAccount;
import model.PersonalAccount;
import model.User;
import model.WithdrawableAccount;
import view.DataChangeView;
import view.ProgressBarButtonView;

public class AccountBalanceCeilingController extends Controller {
	
	PersonalAccount account;
	private ProgressBarButtonView view;
	private User user;
	
	public AccountBalanceCeilingController(User user, PersonalAccount accout, ProgressBarButtonView view) {
		this.account = accout;
		this.view = view;
		this.user = user;
	}

	@Override
	public void displayView() {
		view.setVisible(true);
	}

	@Override
	public void setupViewButtons() {
		view.addButtonListener(new ButtonActionListener());
		view.addAuxButtonListener(new AuxButtonActionListener());
	}

	@Override
	public void setupViewText() {
		
		int min = (int) account.getMinBalance();
		int max = (int) account.getBalanceCeiling();
		double current = account.getBalance();
		int displayedCurrent = (int) current;
		
		view.setProgressBarMin(min);
		view.setProgressBarMax(max);
		view.setProgressBarCurrent(displayedCurrent);
		
		Font font = new Font(Font.SERIF, Font.ITALIC, 12);
		
		view.setAuxLabelText("Minimum: " + min);
		view.setAuxLabelFont(font);
		view.setLabelText(0, "Maximum: " + max);
		view.setLabelFont(0, font);
		
		view.setLabelText(1, "Solde actuel: " + current);
		view.setLabelFont(1, new Font(Font.SERIF, Font.ITALIC, 12));
		
		if (account instanceof PELAccount) {
			view.setAuxVisibility(false);
		}
		
		view.setButtonText("Modifier");
		view.setAuxButtonText("Modifier");
		
		view.setBorder(BorderFactory.createTitledBorder("Plafond de liquidité"));
	}
	
	
	class ButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			DataChangeView newView = new DataChangeView(null, "Edition plafond du compte", true, "plafond", false);
			BalanceCeilingChangeController controller = 
					new BalanceCeilingChangeController(user, newView, AccountBalanceCeilingController.this, account);
			controller.setupView();
			controller.displayView();
		}
	}
	
	class AuxButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			DataChangeView newView = new DataChangeView(null, "Edition seuil minimal du compte", true, "seuil minimal", false);
			MinBalanceChangeController controller = 
					new MinBalanceChangeController(user, newView, AccountBalanceCeilingController.this, 
							(WithdrawableAccount) account);
			controller.setupView();
			controller.displayView();
		}
	}
}
