package controller;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import model.Transaction;
import view.DialogView;
import view.Interaction;
import view.TransactionView;

public class TransactionController extends Controller {
	
	private Transaction transaction;
	private TransactionView view;
	private MainMenuController mainMenuController;
	
	public TransactionController(Transaction transaction, TransactionView view, MainMenuController controller) {
		this.transaction = transaction;
		this.view = view;
		this.mainMenuController = controller;
	}
	
	@Override
	public void setupView() {
		super.setupView();
		view.addInteraction(new ClickInteraction());
	}
	

	@SuppressWarnings("deprecation")
	@Override
	public void setupViewText() {
		view.setLabelText(0, transaction.getType().info());
		view.setLabelFont(0, new Font(Font.DIALOG, Font.BOLD, 15));
		
		view.setLabelFont(1, new Font(Font.DIALOG, Font.BOLD, 20));
		Double amount = transaction.getAmount();
		if (amount > 0) {
			view.setLabelText(1, "+" + amount.toString() + " €");
			if (transaction.getStatus() == Transaction.PENDING) {
				view.setLabelColor(1, new Color(50,200,50));
			}
		} else {
			view.setLabelText(1, amount.toString() + " €");
			if (amount < 0) {
				if (transaction.getStatus() == Transaction.PENDING) {
					view.setLabelColor(1, new Color(200,50,50));
				}	
			}
		}
		
		view.setLabelText(2, transaction.getType().getDirection(amount)
				+ " " + transaction.getLinkedAccount().getName());
		view.setLabelFont(2, new Font(Font.DIALOG, Font.BOLD, 15));
		
		view.setLabelFont(3, new Font(Font.SERIF, Font.ITALIC, 12));
		Date transactionDate = transaction.getDate();
		int day = transactionDate.getDate();
		int month = transactionDate.getMonth() + 1;
		int year = transactionDate.getYear() + 1900;
		view.setLabelText(3, day + "/" + month + "/" + year);
		
		view.setLabelText(4, "Catégorie:");
		view.setLabelFont(4, new Font(Font.SERIF, Font.ITALIC, 12));
		
		view.setLabelText(5, transaction.getCategory());
		view.setLabelFont(5, new Font(Font.DIALOG, Font.BOLD, 12));
		
	}

	@Override
	public void displayView() {
		view.setVisible(true);
	}
	
	class ClickInteraction implements Interaction {
		@Override
		public void perform() {
			String addCategory = "Ajouter catégorie";
			ArrayList<String> knownCategories = mainMenuController.getLoggedUser().getTransactionCategories();
			ArrayList<String> possibleOptions = new ArrayList<String>(knownCategories);
			possibleOptions.add(0, addCategory);
			String newCategory = (String) DialogView.getOptionFromList(
					possibleOptions, "Séléctionnez catégorie", "Édition catégorie");
			if (newCategory != null && newCategory.equals(addCategory)) {
				newCategory = DialogView.getStringInput(
						"Entrez le nom de la nouvelle catégorie: ", "Édition catégorie");
			}
			if (newCategory != null) {
				String password = DialogView.askPassword();
				if (password != null && password.equals(mainMenuController.getLoggedUser().getPassword())) {
					if (!knownCategories.contains(newCategory)) {
						mainMenuController.getLoggedUser().addTransactionCategory(newCategory);
					}
					transaction.setCategory(newCategory);
					view.setLabelText(5, transaction.getCategory());
				}
			}
		}
	}

	@Override
	public void setupViewButtonsActions() {
		// No Buttons here
	}
}
