package controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;

import aux.InvalidFormatException;
import model.Account;
import model.User;
import view.AllPayeesView;
import view.AllTransfersView;
import view.DialogView;
import view.PayeeView;

public class AllPayeesController extends Controller{
	
	private User user;
	private AllPayeesView view;
	private MainMenuController mainMenuController;
	
	public AllPayeesController(User user, AllPayeesView view, MainMenuController controller) {
		this.user = user;
		this.view = view;
		this.mainMenuController = controller;
	}
	
	@Override
	public void displayView() {
		view.setVisible(true);
	}
	
	@Override
	public void setupViewButtonsActions() {
		view.addButtonAction(0, new NewPayeeButton());
		view.addButtonAction(1, new RetrunButtonListener());
	}
	
	@Override
	public void setupViewText() {
		view.setButtonText(0, "Nouveau bénficiaire");
		view.setButtonText(1, "Retour à la liste des virements");
		
		TitledBorder title1 = new TitledBorder("Liste des bénéficiaires");
		title1.setTitleFont(new Font("Arial", Font.BOLD, 15));
		view.setListBorder(title1);
		
		for (Account payee : user.getPayees()) {
			PayeeView payeeView = new PayeeView();
			PayeeController controller = new PayeeController(payee, payeeView, mainMenuController);
			view.addContentToList(payeeView);
			controller.setupView();
			controller.displayView();
		}
	}
	
	class RetrunButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			AllTransfersView transfersView = new AllTransfersView();
			AllTransfersController controller = new AllTransfersController(
					mainMenuController.getLoggedUser(), transfersView, mainMenuController);
			mainMenuController.changeView(transfersView);
			controller.setupView();
			controller.displayView();
		}
	}
	
	
	class NewPayeeButton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String[] input = DialogView.getDoubleStringInput("IBAN: ", "Nom du bénéficiare: ", "Nouveau bénéficiare", false, false);
			if (input != null) {
				String iban = input[0];
				String name = input[1];
				if (iban.matches("[A-Z0-9]{10}")) {
					user.addPayee(new Account(iban, name));
					AllPayeesView allPayees = new AllPayeesView();
					AllPayeesController controller = new AllPayeesController(user, allPayees, mainMenuController);
					mainMenuController.changeView(allPayees);
					controller.setupView();
					controller.displayView();
					DialogView.displayInfoDialog("Bénéficiaire ajouté avec succès.", "");
				} else {
					DialogView.displayError((new InvalidFormatException()).getString());
				}
			}
		}
	}
}
