package controller;

import java.awt.Font;
import javax.swing.border.TitledBorder;
import model.PersonalAccount;
import model.User;
import view.AccountSummaryView;
import view.AllAccountsView;

public class AllAccountsController extends Controller {
	
	private User user;
	private AllAccountsView view;
	private MainMenuController mainMenuController;
	
	
	public AllAccountsController(User user, AllAccountsView view, MainMenuController controller) {
		this.user = user;
		this.view = view;
		this.mainMenuController = controller;
	}
	
	@Override
	public void setupViewText() {
		TitledBorder titleBorder = new TitledBorder("Liste des comptes");
		titleBorder.setTitleFont(new Font("Arial", Font.BOLD, 15));
		view.setScrollPaneBorder(titleBorder);
		
		for (PersonalAccount account : user.getAccounts()) {
			AccountSummaryView accountView = new AccountSummaryView();
			AccountSummaryController controller = new AccountSummaryController(account, accountView, mainMenuController);
			controller.setupView();
			controller.displayView();
			view.addContentToContentBox(accountView);
		}
	}

	@Override
	public void displayView() {
		view.setVisible(true);
	}

	@Override
	public void setupViewButtons() {
		// No buttons here
	}
}
