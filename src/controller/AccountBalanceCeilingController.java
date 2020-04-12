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
	
	public AccountBalanceCeilingController(User user, PersonalAccount account, ProgressBarButtonView view) {
		this.account = account;
		this.view = view;
		this.user = user;
	}

	@Override
	public void displayView() {
		view.setVisible(true);
	}

	@Override
	public void setupViewButtonsActions() {
		view.addButtonListener(new ButtonActionListener());
		view.addAuxButtonListener(new AuxButtonActionListener());
	}

	@Override
	public void setupViewText() {
		
		int min = (int) account.getMinBalance();
		int max = (int) account.getMaxBalance();
		double current = account.getBalance();
		int displayedCurrent = (int) current;
		
		view.setProgressBarMin(min);
		view.setProgressBarMax(max);
		view.setProgressBarCurrent(displayedCurrent);
		
		Font font = new Font(Font.SERIF, Font.ITALIC, 12);
		
		for (int i = 0; i < 4; i++) {
			view.setLabelFont(i, font);
		}
		
		for (int i = 0; i < 2; i++) {
			view.setAuxLabelFont(i, font);
		}
		
		view.setLabelText(0, "Solde actuel: ");
		view.setLabelText(1, Double.toString(current));
		view.setLabelText(2, "Maximim: ");
		view.setLabelText(3, Integer.toString(max));
		
		view.setAuxLabelText(0, "Minimum: ");
		view.setAuxLabelText(1, Integer.toString(min));
		
		view.setButtonText("Modifier");
		view.setAuxButtonText("Modifier");
		
		if (!(account instanceof PELAccount)) {
			view.addAuxComponents();
		}
		
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
