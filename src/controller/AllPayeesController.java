package controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;


import aux.CustomException;
import model.Account;
import model.User;
import view.SummaryListView;
import view.DialogView;
import view.PayeeView;

public class AllPayeesController extends Controller{
	
	private User user;
	private SummaryListView view;
	private MainMenuController mainMenuController;
	
	public AllPayeesController(User user, SummaryListView view, MainMenuController controller) {
		this.user = user;
		this.view = view;
		this.mainMenuController = controller;
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
		view.setContentListBorder(0, title1);
		
		for (Account payee : user.getPayees()) {
			PayeeView payeeView = new PayeeView();
			PayeeController controller = new PayeeController(payee, payeeView, mainMenuController);
			view.addContentToList(0, payeeView);
			controller.setupView();
		}
	}
	
	class RetrunButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			SummaryListView transfersView = new SummaryListView(1,2);
			AllTransfersController controller = new AllTransfersController(
					mainMenuController.getLoggedUser(), transfersView, mainMenuController);
			mainMenuController.changeView(transfersView);
			controller.setupView();
		}
	}
	
	
	class NewPayeeButton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String[] input = DialogView.getDoubleStringInput("IBAN: ", "Nom du bénéficiare: ", "Nouveau bénéficiare", false, false);
			if (input != null) {
				String iban = input[0];
				String name = input[1];
				
				class Editor implements DataEditor {
					
					Account newPayee;
					
					@Override
					public void editData(String newData) throws CustomException {
						Account payee = new Account(iban, name);
						user.addPayee(payee);
						newPayee = payee;
						DialogView.displayInfoDialog("Nouveau bénéficiaire enregistré avec succès.", null);
					}
					@Override
					public void update() {
						PayeeView newView = new PayeeView();
						PayeeController newController = new PayeeController(newPayee, newView, mainMenuController);
						view.addContentToList(0, newView);
						newController.setupView();
					}
				}
				
				Editor editor = new Editor();
				try {
					editor.runSimpleInputEditionProtocol(iban, "[A-Z0-9]{10}", user.getPassword());
				} catch (CustomException e2) {
					DialogView.displayError(e2.getString());
				}
			}
		}
	}
}
