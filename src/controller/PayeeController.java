package controller;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import aux.CustomException;
import model.Account;
import view.AllPayeesView;
import view.DialogView;
import view.PayeeView;

public class PayeeController extends Controller {
	
	private Account payee;
	private PayeeView view;
	private MainMenuController mainMenuController;

	public PayeeController(Account payee, PayeeView view, MainMenuController controller) {
		this.payee = payee;
		this.view = view;
		this.mainMenuController = controller;
	}
	
	
	@Override
	public void displayView() {
	}

	@Override
	public void setupViewButtonsActions() {
		view.addButtonListener(0, new NameEditionButton());
		view.addButtonListener(1, new DeletePayeeButton());
	}

	@Override
	public void setupViewText() {
		Font auxFont = new Font(Font.SERIF, Font. ITALIC, 12);
		Font infoFont = new Font(Font.DIALOG, Font.BOLD, 12);
		
		view.setLabelText(0, "Nom du bénéficiare: ");
		view.setLabelFont(0, auxFont);
		
		view.setLabelText(1, payee.getName());
		view.setLabelFont(1,infoFont);
		
		view.setLabelText(2, "IBAN: ");
		view.setLabelFont(2, auxFont);
		
		view.setLabelText(3, payee.getIban());
		view.setLabelFont(3, infoFont);
		
		view.setButtonText(0, "Editer bénéficiaire");
		view.setButtonText(1, "Supprimer bénéficiaire");
	}
	
	class NameEditionButton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String input = DialogView.getStringInput("Nouveau nom du bénficiaire: ", "Édition bénéficiaire");
			if (input != null) {
				try {
					class Editor implements DataEditor {
						@Override
						public void editData(String newData) throws CustomException {
							payee.setName(newData);
							DialogView.displayInfoDialog("Nouveau nom enregistré avec succès.", null);
						}
						@Override
						public void update() {
							setupViewText();
						}
					}
					Editor editor = new Editor();
					editor.runSimpleInputEditionProtocol(input, ".*", mainMenuController.getLoggedUser().getPassword());
				} catch (CustomException e2) {
					DialogView.displayError(e2.getString());
				}
			}
		}
	}
	
	class DeletePayeeButton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int confirmation = DialogView.askConfirmation("Êtes vous sûrs de vouloir supprimer ce bénéficiaire?", "Confirmation");
			if (confirmation == JOptionPane.OK_OPTION) {
				String password = DialogView.askPassword();
				if (password != null && mainMenuController.getLoggedUser().getPassword().equals(password)) {
					mainMenuController.getLoggedUser().removePayee(payee);
					DialogView.displayInfoDialog("Le bénéficiaire a bien été supprimé", "Confirmation");
					AllPayeesView payeesView = new AllPayeesView();
					AllPayeesController controller = new AllPayeesController(
							mainMenuController.getLoggedUser(), payeesView, mainMenuController);
					mainMenuController.changeView(payeesView);
					controller.setupView();
					controller.displayView();
				}
			}
		}
	}

}
