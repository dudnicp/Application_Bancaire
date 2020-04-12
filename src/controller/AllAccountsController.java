package controller;

import java.awt.Font;
import javax.swing.border.TitledBorder;
import model.CurrentAccount;
import model.LivretAAccount;
import model.PELAccount;
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
		Font titleFont = new Font("Arial", Font.BOLD, 15);
		
		TitledBorder firstBorder = new TitledBorder("Comptes courrants");
		firstBorder.setTitleFont(titleFont);
		
		TitledBorder secondBorder = new TitledBorder("Livrets A");
		secondBorder.setTitleFont(titleFont);
		
		TitledBorder thirdBorder = new TitledBorder("Prêts épargne et logement");
		thirdBorder.setTitleFont(titleFont);
		
		view.setListBorder(0, firstBorder);
		view.setListBorder(1, secondBorder);
		view.setListBorder(2, thirdBorder);
		
		
		for (CurrentAccount account : user.getCurrentAccounts()) {
			AccountSummaryView accountView = new AccountSummaryView();
			AccountSummaryController controller = new AccountSummaryController(account, accountView, mainMenuController);
			controller.setupView();
			controller.displayView();
			view.addContentToList(0, accountView);
		}
		
		for (LivretAAccount account : user.getLivretAAccounts()) {
			AccountSummaryView accountView = new AccountSummaryView();
			AccountSummaryController controller = new AccountSummaryController(account, accountView, mainMenuController);
			controller.setupView();
			controller.displayView();
			view.addContentToList(1, accountView);
		}
		
		for (PELAccount account : user.getPelAccounts()) {
			AccountSummaryView accountView = new AccountSummaryView();
			AccountSummaryController controller = new AccountSummaryController(account, accountView, mainMenuController);
			controller.setupView();
			controller.displayView();
			view.addContentToList(2, accountView);
		}
	}

	@Override
	public void displayView() {
		view.setVisible(true);
	}

	@Override
	public void setupViewButtonsActions() {
		// No buttons here
	}
}
