package controller;

import java.awt.Color;
import java.awt.Font;

import model.PersonalAccount;
import view.AccountSummaryView;
import view.SummaryListView;
import view.Interaction;

public class AccountSummaryController extends Controller {

	private PersonalAccount account;
	private AccountSummaryView view;
	private MainMenuController mainMenuController;
	
	public AccountSummaryController(PersonalAccount account, AccountSummaryView view, MainMenuController controller) {
		this.account = account;
		this.view = view;
		this.mainMenuController = controller;
	}
	
	@Override
	public void setupView() {
		super.setupView();
		view.addInteraction(new ClickInteraction());
	}
	
	
	@Override
	public void setupViewText() {
		
		view.setLabelText(0, account.getName());
		view.setLabelFont(0, new Font(Font.DIALOG, Font.BOLD, 16));

		view.setLabelText(1, account.getType());
		view.setLabelFont(1, new Font(Font.DIALOG, Font.BOLD, 14));
		
		Double amount = account.getBalance();
		view.setLabelText(2, amount + " €");
		view.setLabelFont(2, new Font(Font.DIALOG, Font.BOLD, 18));
		if (amount < 0) {
			view.setLabelColor(2, new Color(200, 50, 50));
		}
		
		view.setLabelText(3, "En traitement:");
		view.setLabelFont(3, new Font(Font.SERIF, Font.ITALIC, 10));
		
		Double pendingAmount = account.getPendingAmount();
		view.setLabelFont(4, new Font(Font.SERIF, Font.ITALIC, 12));
		
		
		if (pendingAmount > 0) {
			view.setLabelText(4, "+ " + pendingAmount.toString() + " €");
			view.setLabelColor(4, new Color(50, 200, 50));
		} else {
			view.setLabelText(4, pendingAmount.toString() + " €");
			if (pendingAmount < 0) {
				view.setLabelColor(4, new Color(200, 50, 50));
			}
		}
		
	}
	
	class ClickInteraction implements Interaction {
		@Override
		public void perform() {
			SummaryListView accountView = new SummaryListView(2,3);
			AccountHistoryController controller = new AccountHistoryController(account, accountView, mainMenuController);
			mainMenuController.changeView(accountView);
			controller.setupView();
		}
	}

	@Override
	public void setupViewButtonsActions() {
		// No buttons here
	}
}
