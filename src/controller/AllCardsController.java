package controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;

import model.Card;
import model.CurrentAccount;
import view.AccountHistoryView;
import view.AllCardsView;
import view.CardView;

public class AllCardsController extends Controller{
	
	private CurrentAccount account;
	private AllCardsView view;
	private MainMenuController mainMenuController;
	
	public AllCardsController(CurrentAccount account, AllCardsView view, MainMenuController controller) {
		this.account = account;
		this.view = view;
		this.mainMenuController = controller;
	}


	@Override
	public void setupViewButtonsActions() {
		view.addButtonAction(0, new ReturnButtonAction());
	}

	@Override
	public void setupViewText() {
		TitledBorder titleBorder = new TitledBorder("Cartes Associées");
		titleBorder.setTitleFont(new Font("Arial", Font.BOLD, 15));
		view.getScrollList().setScrollPaneBorder(titleBorder);
		
		view.setButtonText(0, "Retour à l'historique des transactions");
		
		for (Card card : account.getCards()) {
			CardView cardView = new CardView();
			CardController controller = new CardController(card, cardView);
			controller.setupView();
			view.getScrollList().addContentToContentBox(cardView);
		}
			
	}
	
	class ReturnButtonAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			AccountHistoryView accountView = new AccountHistoryView();
			AccountHistoryController controller = new AccountHistoryController(account, accountView, mainMenuController);
			mainMenuController.changeView(accountView);
			controller.setupView();
		}
	}
}
